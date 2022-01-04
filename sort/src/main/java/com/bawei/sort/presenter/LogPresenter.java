package com.bawei.sort.presenter;

import com.bawei.library_mvp.prsenter.BasePresenter;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.json.LogBean;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 12:00
 *用途：
 */
class LogPresenter extends BasePresenter<LogCollter.LogModel,LogCollter.LogView> {

    public LogPresenter(@NotNull LogCollter.LogModel mModel, @NotNull LogCollter.LogView mView) {
        super(mModel, mView);
    }

    public void LogGet(String username, String password,String repassword){
         getMModel().LogModels(username, password, repassword, new LogCallBack() {
             @Override
             public void success(LogBean logBean) {
                 if (logBean.getErrorCode()==0){
                     getMView().LogViews();
                     ToastUtils.showShort("注册成功");
                 }else{
                     ToastUtils.showShort(logBean.getErrorMsg());
                 }
             }
         });
    }

}
