package com.bawei.home.jomejson.model;

import com.bawei.home.jomejson.api.Api;
import com.bawei.home.jomejson.callback.FoodCallBack;
import com.bawei.home.jomejson.collter.FoodCollter;
import com.bawei.home.jomejson.json.FoodBean;
import com.bawei.library_framework.framenet.FrameNet;
import com.bawei.library_mvp.model.BaseModel;


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
class FoodModel extends BaseModel implements FoodCollter.FoodModel {


    @Override
    public void FoodModels(String page1, String page2, Integer page3, Integer page4, FoodCallBack callBack) {
        FrameNet frameNet = new FrameNet();
        frameNet.getInstance().getFrameNet("http://82.156.178.182:8082/")
                .create(Api.class)
                .getData(page1,page2,page3,page4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull FoodBean foodBean) {
                        List<FoodBean.DataBean> data = foodBean.getData();
                        callBack.success(data);
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
