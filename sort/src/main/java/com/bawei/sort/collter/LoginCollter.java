package com.bawei.sort.collter;

import com.bawei.library_mvp.model.IModel;
import com.bawei.library_mvp.view.IView;
import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.callback.LoginCallBack;
import com.bawei.sort.json.LoginBean;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:28
 *用途：
 */
interface LoginCollter {
    interface LoginModel extends IModel {
        void LoginModels(LoginBean.DataBean loginBean, LoginCallBack loginCallBack);
    }

    interface LoginView extends IView {
        void LogingViews();
    }
}
