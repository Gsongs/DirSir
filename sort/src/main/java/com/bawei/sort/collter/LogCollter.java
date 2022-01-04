package com.bawei.sort.collter;

import com.bawei.library_mvp.model.IModel;
import com.bawei.library_mvp.view.IView;

import com.bawei.sort.callback.LogCallBack;
import com.bawei.sort.json.LogBean;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:28
 *用途：
 */
interface LogCollter {
    interface LogModel extends IModel {
        void LogModels(String username, String password,String repassword, LogCallBack callBack);
    }

    interface LogView extends IView {
        void LogViews();
    }
}
