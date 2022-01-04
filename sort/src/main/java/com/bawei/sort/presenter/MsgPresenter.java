package com.bawei.sort.presenter;

import com.bawei.library_mvp.prsenter.BasePresenter;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.callback.MsgCallBack;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.collter.MsgCollter;
import com.bawei.sort.json.LogBean;
import com.bawei.sort.json.MsgBean;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

public
/**
 *作者：王先生
 *时间：2021/12/13 12:00
 *用途：
 */
class MsgPresenter extends BasePresenter<MsgCollter.MsgModel,MsgCollter.MsgView> {

    public MsgPresenter(@NotNull MsgCollter.MsgModel mModel, @NotNull MsgCollter.MsgView mView) {
        super(mModel, mView);
    }

    public void msg(MsgBean msgBean){
        getMModel().MsgModels(msgBean, new MsgCallBack() {
            @Override
            public void success(MsgBean msgBean) {
                getMView().MsgViews(msgBean);
            }
        });

    }
}