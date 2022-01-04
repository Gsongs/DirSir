package com.bawei.sort.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_framework.imgframenet.ImagesPackaging;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * 我的页面
 */
@Route(path = RoutePath.SORT_PATH)
public class SortActivity extends BaseFragment {

    private ImageView imgs;
    private TextView userReg;
    String name;
    private LinearLayout shouhuo;
    private ImageView daishou;
    private ImageView wodedingdan;
    private ImageView daizhifu;
    private ImageView yiwanchneg;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public int bandLayout() {
        return R.layout.activity_sort;
    }

    @Override
    public void initView() {
        imgs = (ImageView) findViewById(R.id.imgs);
        userReg = (TextView) findViewById(R.id.user_reg);
        shouhuo = (LinearLayout) findViewById(R.id.shouhuo);
        daishou = (ImageView) findViewById(R.id.daishou);
        wodedingdan = (ImageView) findViewById(R.id.wodedingdan);
        daizhifu = (ImageView) findViewById(R.id.daizhifu);
        yiwanchneg = (ImageView) findViewById(R.id.yiwanchneg);
    }

    @Subscribe(sticky = true)
    public void ss(String s) {
        if (s.equals("明日之星")) {
            userReg.setText(s);
        }
    }

    @Override
    public void initData() {

        wodedingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });
        daishou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });
        daizhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });
        yiwanchneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        //收货地址
        shouhuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Take.class);
                startActivity(intent);
            }
        });

        imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        userReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        //头像
        int a = R.drawable.wifi;
        ImagesPackaging imagesPackaging = new ImagesPackaging();
        imagesPackaging.getInstance().PicCrop(getContext(), a, imgs);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}