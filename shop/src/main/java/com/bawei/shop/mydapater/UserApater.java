package com.bawei.shop.mydapater;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bawei.library_framework.data.user.User;
import com.bawei.shop.R;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/15 10:46
 *用途：购物车适配器
 */
class UserApater extends BaseQuickAdapter<User, BaseViewHolder> {

    public UserApater(@Nullable List<User> data) {
        super(R.layout.itershops, data);
        addChildClickViewIds(R.id.jia);
        addChildClickViewIds(R.id.shu);
        addChildClickViewIds(R.id.jian);
        addChildClickViewIds(R.id.chboxs);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, User user) {
        Glide.with(getContext()).load(user.getPic()).into((ImageView) baseViewHolder.getView(R.id.simgs));
        baseViewHolder.setText(R.id.sming,user.getName());
        baseViewHolder.setText(R.id.smingx,user.getName());
        baseViewHolder.setText(R.id.gtvs,""+user.getPrice()+"￥");
        baseViewHolder.setText(R.id.shu,""+user.getNum());
        CheckBox checkBox = baseViewHolder.getView(R.id.chboxs);
        checkBox.setChecked(user.getChbox());





    }
}
