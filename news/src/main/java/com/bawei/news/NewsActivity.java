package com.bawei.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_mvp.view.BaseFragment;
import com.bumptech.glide.Glide;

import io.rong.imkit.RongIM;
import io.rong.imkit.utils.RouteUtils;
import io.rong.imlib.RongIMClient;

@Route(path = RoutePath.NEWS_PATH)
public class NewsActivity extends BaseFragment {

    private ImageView fanhui;
    private TextView zhuce;
    private String a = "你好";
    private ImageView imgs;
    private TextView login;

    @Override
    public int bandLayout() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {

        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);
        imgs = (ImageView) findViewById(R.id.imgs);
        login = (TextView) findViewById(R.id.login);
    }

    @Override
    public void initData() {
        Glide.with(getActivity()).load(R.drawable.my_false).circleCrop().into(imgs);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取token跳转聊天页面
                String token = "ek7Eg2P1T6FnvDQu+JAv8HxuAhGhrtr8vv0iQPhp9go=@x4ky.cn.rongnav.com;x4ky.cn.rongcfg.com";
                RongIM.connect(token, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onSuccess(String userId) {
                        // 登录成功，跳转到默认会话列表页。
                    }
                    @Override
                    public void onError(RongIMClient.ConnectionErrorCode connectionErrorCode) {
                    }
                    @Override
                    public void onDatabaseOpened(RongIMClient.DatabaseOpenStatus databaseOpenStatus) {
                    }
                });
                RouteUtils.routeToConversationListActivity(getContext(), a);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}