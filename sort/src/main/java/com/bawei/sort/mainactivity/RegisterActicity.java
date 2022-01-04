package com.bawei.sort.mainactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bawei.sort.collter.LogCollter;
import com.bawei.sort.model.LogModel;
import com.bawei.sort.presenter.LogPresenter;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public
/**
 *作者：王先生
 *时间：2021/12/13 08:45
 *用途：
 */
class RegisterActicity extends BaseActivity implements LogCollter.LogView {
    private android.widget.EditText haoma;
    private android.widget.Button yanzhengma;
    private android.widget.EditText duanxin;
    private android.widget.EditText pass;
    private android.widget.EditText repass;
    int obj;
    private android.widget.Button zhuce;
    LogPresenter logPresenter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    yanzhengma.setText(obj+"S");
                    obj = (int)msg.obj;
                    break;
            }
        }
    };
    @Override
    public int bandLayout() {
       return R.layout.register;
    }

    @Override
    public void initView() {

        haoma = (EditText) findViewById(R.id.haoma);
        yanzhengma = (Button) findViewById(R.id.yanzhengma);
        duanxin = (EditText) findViewById(R.id.duanxin);
        pass = (EditText) findViewById(R.id.pass);
        repass = (EditText) findViewById(R.id.repass);
        zhuce = (Button) findViewById(R.id.zhuce);

        logPresenter = new LogPresenter(new LogModel(), this);
    }

    @Override
    public void initData() {

        yanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtils.showShort("发送验证码成功");
                if (obj==0){
                    Random random = new Random();
                    double v1 = random.nextDouble();
                    int a = (int) (v1*1000000);

                    duanxin.setText(""+a);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 60; i >=1; i--) {
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
        });
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (haoma.getText().toString().equals("")||pass.getText().toString().equals("")||yanzhengma.getText().toString().equals("")||repass.getText().toString().equals("")){
                    //判断为空的时候什么也不用写 按钮不会执行
                    zhuce.setBackgroundResource(R.drawable.bottons);
                    zhuce.setEnabled(false);
                }else{
                    //编辑框填写东西的时候会变成blue  才会触发点击事件
                    zhuce.setBackgroundResource(R.drawable.bottonsa);
                    zhuce.setEnabled(true);

                    zhuce.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            logPresenter.LogGet(haoma.getText().toString(),pass.getText().toString(),repass.getText().toString());
                        }
                    });
                }
            }
        };
        //实现监听效果
        haoma.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);
        repass.addTextChangedListener(textWatcher);
        yanzhengma.addTextChangedListener(textWatcher);
    }

    @Override
    public void LogViews() {

        Intent intent = new Intent(RegisterActicity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void shot(@NotNull String msg) {

    }
}

