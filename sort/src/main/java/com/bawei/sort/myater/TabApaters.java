package com.bawei.sort.myater;

import android.widget.ImageView;

import com.bawei.library_framework.data.user.User;
import com.bawei.library_framework.room.Users;
import com.bawei.sort.R;
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
class TabApaters extends BaseQuickAdapter<Users, BaseViewHolder> {

    public TabApaters(@Nullable List<Users> data) {
        super(R.layout.tabiter, data);
        addChildClickViewIds(R.id.shuotab);
    }
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Users user) {

        //边角圆形
        ImageView view = baseViewHolder.getView(R.id.simgtab);
        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
        Glide.with(getContext()).load(user.getPics()) //图片地址
                .apply(options)
                .into(view);
        baseViewHolder.setText(R.id.smingtab,user.getNames());
        baseViewHolder.setText(R.id.smingtab,user.getNames());
        baseViewHolder.setText(R.id.gtvtab,""+user.getPrices()+"￥");



    }
}
