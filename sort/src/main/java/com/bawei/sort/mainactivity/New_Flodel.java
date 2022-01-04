package com.bawei.sort.mainactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bawei.sort.collter.MsgCollter;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.model.MsgModel;
import com.bawei.sort.presenter.MsgPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/20 09:02
 *用途：
 */
class New_Flodel extends BaseActivity implements MsgCollter.MsgView {
    private android.widget.ImageView fanhui;
    private android.widget.TextView zhuce;
    private android.widget.EditText names;
    private android.widget.EditText tels;
    private android.widget.EditText dizhi;
    private android.widget.Button tianjia;
    MsgPresenter msgPresenter;

    private   MsgBean msgBean;
    @Override
    public int bandLayout() {
        return R.layout.new_flodel;
    }

    @Override
    public void initView() {

        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);
        names = (EditText) findViewById(R.id.names);
        tels = (EditText) findViewById(R.id.tels);
        dizhi = (EditText) findViewById(R.id.dizhi);
        tianjia = (Button) findViewById(R.id.tianjia);

        msgPresenter = new MsgPresenter(new MsgModel(), this);
    }

    @Override
    public void initData() {
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = names.getText().toString();
                String s1 = tels.getText().toString();
                String s2 = dizhi.getText().toString();

                msgBean = new MsgBean(1, 2766, 1, 1, 1, s, s1, s2);

                msgPresenter.msg(msgBean);

                Intent intent = new Intent(New_Flodel.this, Take.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void shot(@NotNull String msg) {

    }


    @Override
    public void MsgViews(MsgBean msgBean) {

    }
}
