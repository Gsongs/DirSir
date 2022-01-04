package com.bawei.sort.model;

import com.bawei.library_framework.framenet.FrameNet;
import com.bawei.library_mvp.model.BaseModel;
import com.bawei.sort.api.Api;
import com.bawei.sort.callback.LoginCallBack;
import com.bawei.sort.callback.TakeCallBack;
import com.bawei.sort.collter.LoginCollter;
import com.bawei.sort.collter.TakeCollter;
import com.bawei.sort.json.LoginBean;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:29
 *用途：
 */
class TakeModel extends BaseModel implements TakeCollter.TakeModel {
    @Override
    public void TakeModels(Observer<TakeBean> observer) {
        FrameNet frameNet = new FrameNet();
        Retrofit frameNet1 = frameNet.getInstance().getFrameNet("http://82.156.178.182:8082/");
        Api api = frameNet1.create(Api.class);
        api.take_Data().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}

