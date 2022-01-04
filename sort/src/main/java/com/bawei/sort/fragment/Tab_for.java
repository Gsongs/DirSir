package com.bawei.sort.fragment;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;
import com.bawei.sort.mainactivity.PingActivity;
import com.bawei.sort.myater.QuanApaters;
import com.bawei.sort.myater.TabjiaApaters;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/23 10:05
 *用途：
 */

class Tab_for extends BaseFragment {
    private RecyclerView restabfor;
    ArrayList<Users> list = new ArrayList<>();
    @Override
    public int bandLayout() {
        return R.layout.tab_for;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
        restabfor = (RecyclerView) findViewById(R.id.restabfor);
        restabfor.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void initData() {
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();
        List<Users> allUsers = userRoom.getAllUsers();

        for (Users allUser : allUsers) {
            if (allUser.getState()==2){
                list.add(allUser);
            }
        }

        QuanApaters apaters = new QuanApaters(list);
        restabfor.setAdapter(apaters);

    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }
}
