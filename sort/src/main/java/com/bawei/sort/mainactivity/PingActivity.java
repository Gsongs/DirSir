package com.bawei.sort.mainactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/23 09:27
 *用途：
 */
@Route(path = "/for/for")
class PingActivity extends BaseActivity {
    private android.widget.ImageView imgjia;
    private android.widget.TextView tvtjia;
    private TextView tvt1jia;


    private android.widget.RatingBar xingixng;
    private TextView fen;
    private android.widget.EditText pinglun;
    private android.widget.Button fasong;
    String score1 = "";
    private TextView tvss;

    @Override
    public int bandLayout() {
        return R.layout.pingactivity;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
        imgjia = (ImageView) findViewById(R.id.imgjia);
        tvtjia = (TextView) findViewById(R.id.tvtjia);
        tvt1jia = (TextView) findViewById(R.id.tvt1jia);
        xingixng = (RatingBar) findViewById(R.id.xingixng);
        fen = (TextView) findViewById(R.id.fen);
        pinglun = (EditText) findViewById(R.id.pinglun);
        fasong = (Button) findViewById(R.id.fasong);
        tvss = (TextView) findViewById(R.id.tvss);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Users us = (Users) intent.getSerializableExtra("us");

        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
        Glide.with(this).load(us.getPics()) //图片地址
                .apply(options)
                .into(imgjia);

        tvtjia.setText(us.getNames());
        tvt1jia.setText("￥" + us.getPrices());

        xingixng.setRating(us.getRatingBar());
        tvss.setText(us.getText());
        if (us.getState()==3){
            fasong.setVisibility(View.GONE);
            //评论区隐藏
            pinglun.setVisibility(View.GONE);
        }

        System.out.println("aghgjhkjsdfggadfdfsd"+us.getRatingBar());

            fasong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //星星的点击事件
                    xingixng.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                        @Override
                        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                            String score = String.valueOf(rating);
                            //新建一个string类型来把方法里的string类型赋值
                            score1 = fun_getScore(score);
                            //展示赋值后的星星等级
                            fen.setText(score1);
                        }
                    });
                    //评论赋值
                    String s1 = pinglun.getText().toString();
                    tvss.setText(s1);

                    //星星停止
                    xingixng.setIsIndicator(true);
                    //按钮隐藏
                    fasong.setVisibility(View.GONE);
                    //评论区隐藏
                    pinglun.setVisibility(View.GONE);
                    //判断修改数据库
                    UserRoom userRoom = UserDataBase.getInstance(PingActivity.this).getUserRoom();
                    if (xingixng.getRating()!=0.0||pinglun.getText().toString()!=null){
                        us.setRatingBar(xingixng.getRating());
                        us.setText(pinglun.getText().toString());
                        us.setState(3);
                        userRoom.updata(us);
                    }
                }
            });
    }
    //创建一个方法来判断星级是好是坏
    private String fun_getScore(String score){
        String rating = "";
        switch (score){
            case "1.0":
                rating = "差";
                break;

            case "2.0":
                rating = "较差";
                break;

            case "3.0":
                rating = "一般";
                break;

            case "4.0":
                rating = "好";
                break;

            case "5.0":
                rating = "极好";
                break;
        }
        return rating;
    }
}
