package com.bawei.mine.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.data.user.User;
import com.bawei.library_framework.database.UserManager;
import com.bawei.library_framework.logmanager.LogManager;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.mine.R;
import com.bawei.shop.Order;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/13 17:35
 *用途：
 */
class Details_onr extends BaseActivity {
    private android.widget.ImageView fanhui;
    private android.widget.TextView zhuce;
    private android.widget.ImageView imgs1;
    private android.widget.TextView tv1;
    private android.widget.TextView tv2;
    private android.widget.TextView tv3;
    private android.widget.TextView tv4;
    private TextView tv11;
    private ImageView imgview1;
    private ImageView imgview2;
    private ImageView imgview3;
    private ImageView imgview4;
    private android.widget.Button shops;
    private TextView chakan;
    private com.youth.banner.Banner banners;
    ArrayList<ImageView> list = new ArrayList<>();
    String name;
    String yifu;
    String dian;
    String pic;
    private ImageView gouwuche;

    @Override
    public int bandLayout() {
        return R.layout.detais_onr;
    }

    @Override
    public void initView() {

        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv11 = (TextView) findViewById(R.id.tv11);

        imgview1 = (ImageView) findViewById(R.id.imgview1);
        imgview2 = (ImageView) findViewById(R.id.imgview2);
        imgview3 = (ImageView) findViewById(R.id.imgview3);
        imgview4 = (ImageView) findViewById(R.id.imgview4);
        shops = (Button) findViewById(R.id.shops);
        chakan = (TextView) findViewById(R.id.chakan);
        banners = (Banner) findViewById(R.id.banners);
        gouwuche = (ImageView) findViewById(R.id.gouwuche);
    }

    @Override
    public void initData() {

        //购物车图标进入购物车
        gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                EventBus.getDefault().post("ssss");
            }
        });


        //查看评论
        chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details_onr.this,Loading.class);
                intent.putExtra("name",name);
                intent.putExtra("dian",dian);
                intent.putExtra("pic",pic);
                startActivity(intent);
            }
        });
        //返回上一级
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //getintent接收
        Intent intent = getIntent();
        ArrayList<String> imgview111 = intent.getStringArrayListExtra("imgview11");
        list.add(imgview1);
        list.add(imgview2);
        list.add(imgview3);
        list.add(imgview4);

        //log打印
        LogManager.getManager().i("Log初始化完成"+imgview111);
        LogManager.getManager().d("======================");
        LogManager.getManager().v("++++++++++++++++++++++");
        LogManager.getManager().e("======================");
        LogManager.getManager().w("======================");
        pic = intent.getStringExtra("pic");
        name = intent.getStringExtra("name");
        int num = intent.getIntExtra("num",0);
        String num1 = intent.getStringExtra("num1");
        dian = intent.getStringExtra("dian");
        yifu = intent.getStringExtra("yifu");

            for (int i = 0; i < imgview111.size(); i++) {
                if (imgview111.get(i)!=null){
                    Glide.with(this).load(imgview111.get(i)).into(list.get(i));
                }else{
                    Glide.with(this).load(R.drawable.ic_launcher_background).into(list.get(i));
                }
            }

        banners.setIndicator(new CircleIndicator(this),false);
        banners.setAdapter(new BannerImageAdapter<String>(imgview111) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                Glide.with(Details_onr.this).load(data).into(holder.imageView);
            }
        });

        banners.isAutoLoop(false);

        tv1.setText(""+num1+"￥");
        tv11.setText(num+"￥");
        tv2.setText(dian);
        tv3.setText(name);
        tv4.setText(yifu);


        //数据库
       UserManager manager = new UserManager();

       shops.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //加入购物车额
               manager.getUsersDao().insert(new User(null,name,pic,num,1,false));
           }
       });
    }
}
