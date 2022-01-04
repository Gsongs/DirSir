package com.bawei.sort.myater;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;

import com.bawei.library_framework.sp.Preferences;
import com.bawei.sort.R;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public
/**
 *作者：王先生
 *时间：2021/12/20 10:09
 *用途：
 */
class MsgApaters extends BaseMultiItemQuickAdapter<TakeBean.DataBean, BaseViewHolder> {

    public MsgApaters(@Nullable List<TakeBean.DataBean> data) {
        super(data);
        addItemType(0,R.layout.take_iter);
        addChildClickViewIds(R.id.chabox);
        addChildClickViewIds(R.id.del);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TakeBean.DataBean dataBean) {
        baseViewHolder.setText(R.id.ming,dataBean.getAddress());
        baseViewHolder.setText(R.id.shouji,dataBean.getPhonenum());
        baseViewHolder.setText(R.id.dizhi,dataBean.getIsdefault());
        CheckBox view = baseViewHolder.getView(R.id.chabox);
        Integer is = (Integer) Preferences.getInstance().get("is", 211);
        //判断是否是单个选中
        if (dataBean.getId()== is){
            view.setChecked(true);
        }else{
            view.setChecked(false);
        }

    }
}
