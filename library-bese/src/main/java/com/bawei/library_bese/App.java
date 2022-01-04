package com.bawei.library_bese;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.sp.Preferences;
import com.tencent.rtmp.TXLiveBase;

import io.rong.imkit.RongIM;

public
/**
 *作者：王先生
 *时间：2021/12/8 17:04
 *用途：
 */
class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.getInstance().init(this);
        //初始化
        ARouter.init(this);
        ARouter.openDebug();
        String licenceURL = "https://license.vod2.myqcloud.com/license/v2/1306712314_1/v_cube.license"; // 获取到的 licence url
        String licenceKey = "9f5bfa92df43b618220e7c6e43840371"; // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey);
        String appKey = "bmdehs6pbefps";
        RongIM.init(this, appKey);
    }
}
