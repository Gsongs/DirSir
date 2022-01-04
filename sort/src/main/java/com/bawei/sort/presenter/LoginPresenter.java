package com.bawei.sort.presenter;

import com.bawei.library_mvp.prsenter.BasePresenter;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.callback.LoginCallBack;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.collter.LoginCollter;
import com.bawei.sort.json.LogBean;
import com.bawei.sort.json.LoginBean;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

public
/**
 *作者：王先生
 *时间：2021/12/13 12:00
 *用途：
 */
class LoginPresenter extends BasePresenter<LoginCollter.LoginModel,LoginCollter.LoginView> {

    public LoginPresenter(@NotNull LoginCollter.LoginModel mModel, @NotNull LoginCollter.LoginView mView) {
        super(mModel, mView);
    }

    public void LoginGet(LoginBean.DataBean loginBean){
         getMModel().LoginModels(loginBean, new LoginCallBack() {
             @Override
             public void success(LoginBean loginBean) {
                 if (loginBean.getCode()==200){
                     getMView().LogingViews();
                     ToastUtils.showShort("登录成功");
                 }else{
                     ToastUtils.showShort("登录失败");
                 }
             }
         });
    }

}
