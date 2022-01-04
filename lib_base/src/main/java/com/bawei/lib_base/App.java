package com.bawei.lib_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public
/**
 *作者：王先生
 *时间：2021/12/7 17:23
 *用途：
 */
class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        ARouter.openLog();
        ARouter.openDebug();
    }
}
