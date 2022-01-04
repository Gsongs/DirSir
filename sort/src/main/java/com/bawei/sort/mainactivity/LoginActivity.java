package com.bawei.sort.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bawei.sort.collter.LoginCollter;
import com.bawei.sort.json.LoginBean;
import com.bawei.sort.model.LoginModel;
import com.bawei.sort.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

public
/**
 *作者：王先生
 *时间：2021/12/12 18:55
 *用途：
 */
class LoginActivity extends BaseActivity implements LoginCollter.LoginView {
    private android.widget.TextView zhuce;
    private android.widget.EditText user;
    private android.widget.EditText pass;
    private android.widget.Button denglu;
    private TextView wjmm;
    private android.widget.ImageView fanhui;
    public String s = "民日之星";
    private LoginPresenter loginPresenter;
    @Override
    public int bandLayout() {
        return R.layout.login;
    }

    @Override
    public void initView() {

        zhuce = (TextView) findViewById(R.id.zhuce);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        denglu = (Button) findViewById(R.id.denglu);
        wjmm = (TextView) findViewById(R.id.wjmm);
        fanhui = (ImageView) findViewById(R.id.fanhui);

        loginPresenter = new LoginPresenter(new LoginModel(), this);
    }

    @Override
    public void initData() {
        //返回上一级
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //忘记密码
        wjmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,PasswordActivity.class);
                startActivity(intent);
            }
        });
        //注册账号
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActicity.class);
                startActivity(intent);
            }
        });

        //TextWatcher变色监听事件
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (user.getText().toString().equals("")||pass.getText().toString().equals("")){
                    //判断为空的时候什么也不用写 按钮不会执行
                    denglu.setBackgroundResource(R.drawable.bottons);
                    denglu.setEnabled(false);
                }else{
                    //编辑框填写东西的时候会变成blue  才会触发点击事件
                    denglu.setBackgroundResource(R.drawable.bottonsa);
                    denglu.setEnabled(true);

                    denglu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            LoginBean.DataBean loginBean = new LoginBean.DataBean(1,user.getText().toString(),pass.getText().toString(),"男","s");
                            loginPresenter.LoginGet(loginBean);
                            //EvenBus跳转我的页面
                            EventBus.getDefault().postSticky("明日之星");
                        }
                    });
                }
            }
        };
       //实现监听效果
        user.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);
        }

    @Override
    public void LogingViews() {
        //sp存储
        SharedPreferences name = getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = name.edit();
        edit.putBoolean("is",true);
        edit.commit();
        EventBus.getDefault().postSticky("s");
        //点击登录成功的时候回返回我的页面
        finish();
    }

    @Override
    public void shot(@NotNull String msg) {

    }
}

