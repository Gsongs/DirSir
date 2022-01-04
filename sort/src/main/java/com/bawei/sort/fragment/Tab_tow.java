package com.bawei.sort.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;
import com.bawei.sort.myater.PingApaters;
import com.bawei.sort.myater.QuanApaters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/22 14:00
 *用途：
 */
class Tab_tow extends BaseFragment {
    private RecyclerView ressping;
    ArrayList<Users> list = new ArrayList<>();
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void abc(String abc){
        if (abc!=null){

        }
    }
    @Override
    public int bandLayout() {
        return R.layout.tab_tow;
    }

    @Override
    public void initView() {

        ressping = (RecyclerView) findViewById(R.id.ressping);
        ressping.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void initData() {
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();
        List<Users> allUsers = userRoom.getAllUsers();

        for (Users allUser : allUsers) {
            if (allUser.getState()==0){
                list.add(allUser);
            }
        }
        QuanApaters apaters = new QuanApaters(list);
        ressping.setAdapter(apaters);
        apaters.notifyDataSetChanged();
/*
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();
        List<Users> allUsers = userRoom.getAllUsers();
        PingApaters apaters = new PingApaters(allUsers);
        ressping.setAdapter(apaters);

        apaters.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                if (view.getId() == R.id.quzhifu) {
                    ARouter.getInstance().build("/pay/pay").withString("pricepay",allUsers.get(position).getPrices()).navigation();
                }
            }
        });*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
