package com.bawei.library_framework.framenet

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *作者：王先生
 *时间：2021/12/10 19:04
 *用途：网络单例封装
 */
class FrameNet {

    @Volatile
    private var frameNet: FrameNet? = null

    fun getInstance(): FrameNet? {
        if (frameNet == null) {
            synchronized(FrameNet::class.java) {
                if (frameNet == null) {
                    frameNet = FrameNet()
                }
            }
        }
        return frameNet
    }

    //外部调用方法
    fun getFrameNet(url: String?): Retrofit? {
        //创建Retrofit实例对象
        return Retrofit.Builder().baseUrl(url) //实现异步调用任务
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //使用Gson作为json数据的转换器
            .addConverterFactory(GsonConverterFactory.create()) //拦截器
            .client(OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
            ).build()
    }

}