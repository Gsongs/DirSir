package com.bawei.sort.model;

import com.bawei.library_framework.framenet.FrameNet;
import com.bawei.library_mvp.model.BaseModel;
import com.bawei.sort.api.Api;
import com.bawei.sort.callback.LoginCallBack;
import com.bawei.sort.callback.MsgCallBack;
import com.bawei.sort.collter.LoginCollter;
import com.bawei.sort.collter.MsgCollter;
import com.bawei.sort.json.LoginBean;
import com.bawei.sort.json.MsgBean;

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
class MsgModel extends BaseModel implements MsgCollter.MsgModel {


    @Override
    public void MsgModels(MsgBean msgBean, MsgCallBack msgCallBack) {
        FrameNet frameNet = new FrameNet();
        frameNet.getInstance().getFrameNet("http://82.156.178.182:8082/")
                .create(Api.class)
                .Getmsg(msgBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull MsgBean msgBean) {
                             msgCallBack.success(msgBean);
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

