package com.bawei.framework.framenet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.List;

import javax.security.auth.Subject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
/**
 *作者：王先生
 *时间：2021/12/8 13:07
 *用途：网络框架单例
 */
class FrameNet {
    //实现双重锁保证可见性。使用 volatile定义的变量，将会保证对所有线程的可见性。禁止指令重排序优化。
    //由于 volatile禁止对象创建时指令之间重排序，所以其他线程不会访问到一个未初始化的对象，从而保证安全性。
    private volatile static FrameNet frameNet = null;

    public static FrameNet getInstance() {
        if (frameNet == null) {
            synchronized (FrameNet.class) {
                if (frameNet == null) {
                    frameNet = new FrameNet();
                }
            }
        }
        return frameNet;
    }

    //外部调用方法
    public Retrofit getFrameNet(String url) {
        //创建Retrofit实例对象
        return new Retrofit.Builder().baseUrl(url)
                 //实现异步调用任务
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 //使用Gson作为json数据的转换器
                 .addConverterFactory(GsonConverterFactory.create())
                //拦截器
                 .client(new OkHttpClient.Builder()
                 .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                 .build()).build();

    }

    //判断网络是否可用
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
        } else {
            cm.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

}
