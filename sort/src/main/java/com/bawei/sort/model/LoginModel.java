package com.bawei.sort.model;

import com.bawei.library_framework.framenet.FrameNet;
import com.bawei.library_mvp.model.BaseModel;
import com.bawei.sort.api.Api;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.callback.LoginCallBack;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.collter.LoginCollter;
import com.bawei.sort.json.LogBean;
import com.bawei.sort.json.LoginBean;

import org.jetbrains.annotations.NotNull;

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
class LoginModel extends BaseModel implements LoginCollter.LoginModel {


    @Override
    public void LoginModels(LoginBean.DataBean loginBean, LoginCallBack loginCallBack) {
        FrameNet frameNet = new FrameNet();
        frameNet.getInstance().getFrameNet("http://82.156.178.182:8082/")
                .create(Api.class)
                .getLogin(loginBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull LoginBean loginBean) {
                           loginCallBack.success(loginBean);
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

