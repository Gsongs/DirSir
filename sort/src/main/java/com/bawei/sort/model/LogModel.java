package com.bawei.sort.model;

import com.bawei.library_framework.framenet.FrameNet;
import com.bawei.library_mvp.model.BaseModel;
import com.bawei.sort.api.Api;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.json.LogBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:29
 *用途：
 */
class LogModel extends BaseModel implements LogCollter.LogModel {
    @Override
    public void LogModels(String username, String password, String repassword, LogCallBack callBack) {
        FrameNet frameNet = new FrameNet();
        frameNet.getInstance().getFrameNet("https://www.wanandroid.com/")
                .create(Api.class)
                .reg(username,password,repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LogBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull LogBean logBean) {

                        callBack.success(logBean);
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
