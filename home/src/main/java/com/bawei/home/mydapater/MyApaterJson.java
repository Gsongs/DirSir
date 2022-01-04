package com.bawei.home.mydapater;

import android.view.View;
import android.widget.ImageView;

import com.bawei.home.R;
import com.bawei.home.jomejson.json.FoodBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/14 09:11
 *用途：
 */
class MyApaterJson extends BaseMultiItemQuickAdapter<FoodBean.DataBean, BaseViewHolder> {
    public MyApaterJson(@Nullable List<FoodBean.DataBean> data) {
        super(data);
        addItemType(0, R.layout.iter);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, FoodBean.DataBean dataBean) {
        if (dataBean.getIndex()==0){
     /*       Glide.with(getContext()).load(dataBean.getPictUrl()).into((ImageView) baseViewHolder.getView(R.id.homeimg));*/
            ImageView view = baseViewHolder.getView(R.id.homeimg);
            RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
            Glide.with(getContext()).load(dataBean.getPictUrl()) //图片地址
                    .apply(options)
                    .into(view);
            baseViewHolder.setText(R.id.hometvs,dataBean.getShopTitle());
        }
    }
}
