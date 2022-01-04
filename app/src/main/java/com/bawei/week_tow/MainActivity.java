package com.bawei.week_tow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import com.bawei.library_bese.RoutePath;
import com.bawei.library_framework.database.UserManager;
import com.bawei.library_mvp.view.BaseActivity;

import com.bawei.sort.mainactivity.LoginActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
//高内聚低耦合，有利于团队作战
//简单地说，模块化就是有组织地把一个大文件拆成独立并互相依赖的多个小模块。
@Route(path = "/com/bawei/week_tow/MainActivity")
public class MainActivity extends BaseActivity {
    //保存点击的时间
    private long exitTime = 0;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    ArrayList<Fragment> list;
    private android.widget.LinearLayout lab;
    private com.chaychan.library.BottomBarLayout bottonLab;

    @Override
    public int bandLayout() {
        return R.layout.activity;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        lab = (LinearLayout) findViewById(R.id.lab);
        bottonLab = (BottomBarLayout) findViewById(R.id.botton_lab);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void as(String as){
        bottonLab.setCurrentItem(2);
    }

    @Override
    public void initData() {

        SharedPreferences user = getSharedPreferences("name", Context.MODE_PRIVATE);
        boolean is = user.getBoolean("is", false);
        if (is){
            ToastUtils.showShort("欢迎");
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }


        //初始化路径
        Fragment fragment1 = (Fragment) ARouter.getInstance().build(RoutePath.HOME_PATH).navigation();
        Fragment fragment2 = (Fragment) ARouter.getInstance().build(RoutePath.MINE_PATH).navigation();
        Fragment fragment3 = (Fragment) ARouter.getInstance().build(RoutePath.SHOP_PATH).navigation();
        Fragment fragment4 = (Fragment) ARouter.getInstance().build(RoutePath.NEWS_PATH).navigation();
        Fragment fragment5 = (Fragment) ARouter.getInstance().build(RoutePath.SORT_PATH).navigation();


        list = new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);

        bottonLab.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int previousPosition, int currentPosition) {
                if (previousPosition==0&&previousPosition==currentPosition&&!list.get(currentPosition).isAdded()){
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.lab,list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
                if (previousPosition!=currentPosition&&!list.get(currentPosition).isAdded()){
                    getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .add(R.id.lab,list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
                if (previousPosition!=currentPosition){
                    getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .show(list.get(currentPosition))
                            .commitAllowingStateLoss();
                }
            }
        });

        bottonLab.setCurrentItem(0);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("wang","stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("wang", "onResume: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}