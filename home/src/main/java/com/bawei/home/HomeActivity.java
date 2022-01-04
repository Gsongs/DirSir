package com.bawei.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.home.jomejson.collter.FoodCollter;
import com.bawei.home.jomejson.json.FoodBean;
import com.bawei.home.jomejson.model.FoodModel;
import com.bawei.home.jomejson.presenter.FoodPresenter;
import com.bawei.home.mydapater.MyApaterJson;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.mine.main.Details_onr;
import com.bawei.sort.mainactivity.LoginActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.superluo.textbannerlibrary.TextBannerView;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Route(path = RoutePath.HOME_PATH)
public class HomeActivity extends BaseFragment implements FoodCollter.FoodView {

    private Banner banners;
    private TextBannerView textbanner;
    private ImageView zhobo;
    private ImageView diannao;
    private ImageView shouji;
    private ImageView ipda;
    private ImageView jiaju;
    private ImageView jiadian;
    private ImageView yundong;
    private ImageView xiuxian;
    private RecyclerView ress;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    String a = ("https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg");
    String b = ("https://img10.360buyimg.com/n7/jfs/t5905/106/1120548052/61075/6eafa3a5/592f8f7bN763e3d30.jpg");
    String c = ("https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg");
    String d = ("https://img11.360buyimg.com/n7/jfs/t4447/301/1238553109/193354/13c7e995/58db19a7N25101fe4.jpg");
    String e = ("https://img14.360buyimg.com/n1/s190x190_jfs/t7525/189/155179632/395056/e200017f/598fb8a4N7800dee6.jpg");
    String f = ("https://img10.360buyimg.com/n7/jfs/t5584/99/6135095454/371625/423b9ba5/59681d91N915995a7.jpg");
    String g = ("https://img14.360buyimg.com/n0/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg");

    String Topic_one = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2069038579,1558413647&fm=26&gp=0.jpg";
    String Topic_two = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1975162372,3010774958&fm=26&gp=0.jpg";
    String Topic_three = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1034894772,889898861&fm=26&gp=0.jpg";
    String Topic_four = "http://img.zcool.cn/community/01796c58772f66a801219c77e4fc04.png@1280w_1l_2o_100sh.png";
    String Topic_five = "http://img.zcool.cn/community/0154805791ffeb0000012e7edba495.jpg@900w_1l_2o_100sh.jpg";
    private ImageView img7;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private LinearLayout lab1;
    private LinearLayout lab2;
    private Banner bannerss;
    private RecyclerView resview;
    private String page = "装饰";
    private String page1 = "装饰";
    private int page2 = 25;
    private int page3 = 25;

    FoodPresenter foodPresenter;
    

    @Override
    public int bandLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {

        banners = (Banner) findViewById(R.id.banners);
        textbanner = (TextBannerView) findViewById(R.id.textbanner);
        zhobo = (ImageView) findViewById(R.id.zhobo);
        diannao = (ImageView) findViewById(R.id.diannao);
        shouji = (ImageView) findViewById(R.id.shouji);
        ipda = (ImageView) findViewById(R.id.ipda);
        jiaju = (ImageView) findViewById(R.id.jiaju);
        jiadian = (ImageView) findViewById(R.id.jiadian);
        yundong = (ImageView) findViewById(R.id.yundong);
        xiuxian = (ImageView) findViewById(R.id.xiuxian);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);
        img7 = (ImageView) findViewById(R.id.img7);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        lab1 = (LinearLayout) findViewById(R.id.lab1);
        lab2 = (LinearLayout) findViewById(R.id.lab2);
        bannerss = (Banner) findViewById(R.id.bannerss);
        resview = (RecyclerView) findViewById(R.id.resview);
        resview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        foodPresenter = new FoodPresenter(new FoodModel(), this);
    }


    @Override
    public void initData() {

       zhobo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ARouter.getInstance().build("/l/l").navigation();
           }
       });
        foodPresenter.doGet(page,page1,page2,page3);

        //加载图片
        Glide.with(getContext()).load(a).into(img1);
        Glide.with(getContext()).load(b).into(img2);
        Glide.with(getContext()).load(c).into(img3);
        Glide.with(getContext()).load(d).into(img4);
        Glide.with(getContext()).load(e).into(img5);
        Glide.with(getContext()).load(f).into(img6);
        Glide.with(getContext()).load(g).into(img7);

        //删除线
        tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv5.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv6.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv7.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        ArrayList<String> strings = new ArrayList<>();
        strings.add(Topic_one);
        strings.add(Topic_two);
        strings.add(Topic_three);
        strings.add(Topic_four);
        strings.add(Topic_five);

        //第二个参数是指示器显示或隐藏
        bannerss.setIndicator(new CircleIndicator(getContext()), false);
        bannerss.setAdapter(new BannerImageAdapter<String>(strings) {

            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                Glide.with(getActivity()).load(data).into(holder.imageView);
            }
        });

        bannerss.setBannerGalleryEffect(110, 110, 30);
        bannerss.isAutoLoop(false);


        //banner轮播图
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner_one);
        list.add(R.drawable.home_banner_two);
        list.add(R.drawable.home_banner_three);


        //滚动页面指示器
        banners.setIndicator(new CircleIndicator(getContext()));
        banners.setAdapter(new BannerImageAdapter<Integer>(list) {

            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });

        banners.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        banners.setIndicatorSelectedColor(Color.GRAY);
        banners.setIndicatorNormalColor(Color.WHITE);


        //TextBannerView
        ArrayList<String> title = new ArrayList<>();
        title.add("夏日炎炎，第一波福利还有30秒到达战场");
        title.add("新用户立减1000元优惠券");

        textbanner.setDatas(title);

    }

    @Override
    public void FoodModels(List<FoodBean.DataBean> foodBeans) {
        MyApaterJson json = new MyApaterJson(foodBeans);
        resview.setAdapter(json);
        json.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                Intent intent = new Intent(getActivity(), Details_onr.class);
                intent.putExtra("pic", foodBeans.get(position).getPictUrl());
                intent.putExtra("name", foodBeans.get(position).getTitle());
                intent.putExtra("num",foodBeans.get(position).getShopDsr());
                intent.putExtra("dian", foodBeans.get(position).getShopTitle());
                intent.putExtra("yifu", foodBeans.get(position).getCouponInfo());
                intent.putExtra("num1",foodBeans.get(position).getCommissionRate());
                intent.putStringArrayListExtra("imgview11", (ArrayList<String>) foodBeans.get(position).getSmallImages());
                startActivity(intent);
            }
        });
    }

    @Override
    public void shot(@NotNull String msg) {

    }

}