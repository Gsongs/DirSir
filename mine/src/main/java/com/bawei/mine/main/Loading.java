package com.bawei.mine.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.mine.R;
import com.bumptech.glide.Glide;

public
/**
 *作者：王先生
 *时间：2021/12/16 09:16
 *用途：
 */
class Loading extends BaseActivity {
;
    private android.widget.Button fasong;
    private android.widget.TextView tex;
    private android.widget.EditText exstring;
    private androidx.recyclerview.widget.RecyclerView ress;
    private TextView tex1;
    private TextView xiaoxi;
    private android.widget.ImageView imgs;

    @Override
    public int bandLayout() {
        return R.layout.loading;
    }

    @Override
    public void initView() {


        fasong = (Button) findViewById(R.id.fasong);
        tex = (TextView) findViewById(R.id.tex);
        exstring = (EditText) findViewById(R.id.exstring);

        tex1 = (TextView) findViewById(R.id.tex1);
        xiaoxi = (TextView) findViewById(R.id.xiaoxi);
        imgs = (ImageView) findViewById(R.id.imgs);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String dian = intent.getStringExtra("dian");
        String pic = intent.getStringExtra("pic");

        Glide.with(this).load(pic).circleCrop().into(imgs);

        tex.setText(dian);
        tex1.setText(name);

        fasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = exstring.getText().toString();
                xiaoxi.setText(s);
            }
        });

    }
}
