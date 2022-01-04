package com.bawei.mine.mydapater;

import android.widget.ImageView;

import com.bawei.mine.R;
import com.bawei.mine.json.FoodBean;
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
 *时间：2021/12/13 12:06
 *用途：
 */
class Fragment_oneApter extends BaseMultiItemQuickAdapter<FoodBean.DataBean, BaseViewHolder> {
    public Fragment_oneApter(@Nullable List<FoodBean.DataBean> data) {
        super(data);
        addItemType(0, R.layout.iter1);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, FoodBean.DataBean dataBean) {
        if (dataBean.getIndex()==0){
            ImageView view = baseViewHolder.getView(R.id.img1);
            RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
            Glide.with(getContext()).load(dataBean.getPictUrl()) //图片地址
                    .apply(options)
                    .into(view);
            baseViewHolder.setText(R.id.tvt1,dataBean.getCategoryName());
        }
    }
}
