package com.bawei.sort.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;
import com.bawei.sort.myater.QuanApaters;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/23 10:05
 *用途：
 */
class Tab_three extends BaseFragment {
    private RecyclerView resthree;
    ArrayList<Users> list = new ArrayList<>();

    @Override
    public int bandLayout() {
        return R.layout.tab_three;
    }

    @Override
    public void initView() {

        resthree = (RecyclerView) findViewById(R.id.resthree);
        resthree.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
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
        resthree.setAdapter(apaters);
        apaters.notifyDataSetChanged();
    }

}
