package com.bawei.sort.fragment;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.sort.R;
import com.bawei.sort.myater.QuanApaters;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/23 10:05
 *用途：
 */
class Tab_five extends BaseFragment {
    private RecyclerView resfive;
    ArrayList<Users> list = new ArrayList<>();
    @Override
    public int bandLayout() {
        return R.layout.tab_five;
    }

    @Override
    public void initView() {

        resfive = (RecyclerView) findViewById(R.id.resfive);
        resfive.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void initData() {
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();
        List<Users> allUsers = userRoom.getAllUsers();

        for (Users allUser : allUsers) {
            list.add(allUser);
        }
        Log.i("assssss",""+list);

        QuanApaters apaters = new QuanApaters(list);
        resfive.setAdapter(apaters);
        apaters.notifyDataSetChanged();

        apaters.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                userRoom.delete(list.get(position));
                apaters.notifyDataSetChanged();
                apaters.remove(list.get(position));
                ToastUtils.showShort("删除成功");
                return false;
            }
        });
    }
}
