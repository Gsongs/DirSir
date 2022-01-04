package com.bawei.home.mainactivity;

import android.view.View;
import android.widget.Button;

import com.bawei.home.R;
import com.bawei.library_mvp.view.BaseActivity;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public
/**
 *作者：王先生
 *时间：2021/12/22 09:04
 *用途：
 */
class LiveActivity_tow extends BaseActivity {
    private com.tencent.rtmp.ui.TXCloudVideoView videoView;
    TXLivePlayer mLivePlayer;

    TXCloudVideoView mView;
    private Button zanting;
    private Button kaishi;
    @Override
    public int bandLayout() {
        return R.layout.liveactivity_tow
                ;
    }

    @Override
    public void initView() {
        //mPlayerView 即 step1 中添加的界面 view
        videoView = (TXCloudVideoView) findViewById(R.id.video_view);
        //创建 player 对象
        mLivePlayer = new TXLivePlayer(this);

        //关键 player 对象与界面 view
        mLivePlayer.setPlayerView(videoView);

        zanting = (Button) findViewById(R.id.zanting);
        kaishi = (Button) findViewById(R.id.kaishi);
    }

    @Override
    public void initData() {
        // 设置填充模式
        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION);
        //关键 player 对象与界面 view
        mLivePlayer.setPlayerView(videoView);
        String flvUrl = "http://103.18.208.185/liveplay-kk.rtxapp.com/live/program/live/tjwshd/4000000/mnf.m3u8";
        mLivePlayer.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_VOD_HLS); //推荐 FLV

        kaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 继续
                mLivePlayer.resume();
            }
        });
        zanting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 暂停
                mLivePlayer.pause();
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mLivePlayer.stopPlay(true); // true 代表清除最后一帧画面
        videoView.onDestroy();
    }
}
