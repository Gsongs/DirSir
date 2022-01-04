package com.bawei.sort.presenter;

import com.bawei.library_mvp.prsenter.BasePresenter;
import com.bawei.sort.callback.MsgCallBack;
import com.bawei.sort.callback.TakeCallBack;
import com.bawei.sort.collter.MsgCollter;
import com.bawei.sort.collter.TakeCollter;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;
import com.bawei.sort.mainactivity.Take;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public
/**
 *作者：王先生
 *时间：2021/12/13 12:00
 *用途：
 */
class TakePresenter extends BasePresenter<TakeCollter.TakeModel,TakeCollter.TakeView> {

    public TakePresenter(@NotNull TakeCollter.TakeModel mModel, @NotNull TakeCollter.TakeView mView) {
        super(mModel, mView);
    }

  public void get(){
        getMModel().TakeModels(new Observer<TakeBean>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull TakeBean takeBean) {
                getMView().TakeViews(takeBean);
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