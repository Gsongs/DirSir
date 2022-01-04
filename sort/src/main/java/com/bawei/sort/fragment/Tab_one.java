package com.bawei.sort.fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.library_framework.data.db.UserDao;
import com.bawei.library_framework.data.user.User;
import com.bawei.library_framework.database.UserManager;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;
import com.bawei.sort.myater.QuanApaters;
import com.bawei.sort.myater.TabApaters;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/22 14:00
 *用途：
 */
class Tab_one extends BaseFragment {
    private RecyclerView restab;
    ArrayList<Users> list = new ArrayList<>();
    @Override
    public int bandLayout() {
        return R.layout.tab_one;
    }

    @Override
    public void initView() {

        restab = (RecyclerView) findViewById(R.id.restab);
        restab.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void initData() {
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();
        List<Users> allUsers = userRoom.getAllUsers();
        System.out.println(allUsers);

        for (Users allUser : allUsers) {
            if (allUser.getState()==1){
                list.add(allUser);
            }
        }

        QuanApaters apaters = new QuanApaters(list);
        restab.setAdapter(apaters);
        apaters.notifyDataSetChanged();
    }


}
