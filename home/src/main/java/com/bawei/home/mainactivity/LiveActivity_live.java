package com.bawei.home.mainactivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bawei.home.R;
import com.bawei.library_mvp.view.BaseActivity;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

import static android.content.ContentValues.TAG;

public

/**
 * 作者：王先生
 * 时间：2021/12/22 09:52
 * 用途：
 */
class LiveActivity_live extends BaseActivity {
    TXLivePusher mLivePusher;

    private android.widget.Button tui;

    @Override
    public int bandLayout() {
        return R.layout.liveactivity_live;
    }

    @Override
    public void initView() {
        TXLivePushConfig mLivePushConfig  = new TXLivePushConfig();

        mLivePusher = new TXLivePusher(this);

// 一般情况下不需要修改 config 的默认配置
        mLivePusher.setConfig(mLivePushConfig);

    }

    @Override
    public void initData() {
        //启动本地摄像头预览
        TXCloudVideoView mPusherView = (TXCloudVideoView) findViewById(R.id.pusher_tx_cloud_view);
        mLivePusher.startCameraPreview(mPusherView);

                String rtmpURL = "rtmp://test.com/live/xxxxxx"; //此处填写您的 rtmp 推流地址
                int ret = mLivePusher.startPusher(rtmpURL.trim());
                if (ret == -5) {
                    Log.i(TAG, "startRTMPPush: license 校验失败");
                }
            }
}
