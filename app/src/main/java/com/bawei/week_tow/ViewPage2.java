package com.bawei.week_tow;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.bawei.library_mvp.view.BaseActivity;

public
/**
 *作者：王先生
 *时间：2021/12/21 14:16
 *用途：
 */
class ViewPage2 extends BaseActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                   int obj = (int)msg.obj;
                   if (obj==1){
                       Intent intent = new Intent(ViewPage2.this,MainActivity.class);
                       startActivity(intent);
                   }
                    break;
            }
        }
    };
    @Override
    public int bandLayout() {
        return R.layout.viewpager2;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i >=1; i--) {
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage();
                        message.what=1;
                        message.obj=i;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
