package com.bawei.shop.mydapater;

import android.widget.ImageView;

import com.bawei.library_framework.data.user.User;
import com.bawei.shop.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/15 10:46
 *用途：
 */
class OrderApater extends BaseQuickAdapter<User, BaseViewHolder> {

    public OrderApater(@Nullable List<User> data) {
        super(R.layout.orderiter, data);
    }
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, User user) {
 /*       Glide.with(getContext()).load(user.getPic()).into((ImageView) baseViewHolder.getView(R.id.simgorder));*/
        //边角圆形
        ImageView view = baseViewHolder.getView(R.id.simgorder);
        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
        Glide.with(getContext()).load(user.getPic()) //图片地址
                .apply(options)
                .into(view);
        baseViewHolder.setText(R.id.smingorders,user.getName());
        baseViewHolder.setText(R.id.smingorder,user.getName());
        baseViewHolder.setText(R.id.gtvorder,""+user.getPrice()+"￥");
        baseViewHolder.setText(R.id.shuorder,""+user.getNum());



    }
}
