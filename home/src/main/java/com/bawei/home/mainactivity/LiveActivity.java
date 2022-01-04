package com.bawei.home.mainactivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.home.R;
import com.bawei.library_mvp.view.BaseActivity;

public
/**
 *作者：王先生
 *时间：2021/12/20 19:48
 *用途：直播
 */
@Route(path = "/l/l")
class LiveActivity extends BaseActivity {


    private android.widget.ImageView fanhui;
    private android.widget.TextView baocun;
    private android.widget.ImageView live1;
    private android.widget.ImageView live2;
    private android.widget.ImageView live3;
    private android.widget.LinearLayout zhibos;

    @Override
    public int bandLayout() {
        return R.layout.liveactivity;
    }

    @Override
    public void initView() {

        fanhui = (ImageView) findViewById(R.id.fanhui);
        baocun = (TextView) findViewById(R.id.baocun);
        live1 = (ImageView) findViewById(R.id.live1);
        live2 = (ImageView) findViewById(R.id.live2);
        live3 = (ImageView) findViewById(R.id.live3);
        zhibos = (LinearLayout) findViewById(R.id.zhibos);
    }

    @Override
    public void initData() {
        //跳转直播页面
        zhibos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(LiveActivity.this,LiveActivity_live.class);
                startActivity(intent4);
            }
        });

     live1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(LiveActivity.this,LiveActivity_one.class);
             startActivity(intent);
         }
     });
        live2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LiveActivity.this,LiveActivity_tow.class);
                startActivity(intent1);
            }
        });
        live3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LiveActivity.this,LiveActivity_three.class);
                startActivity(intent2);
            }
        });
    }

}
