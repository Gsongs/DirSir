package com.bawei.sort.myater;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.sort.R;
import com.bawei.sort.mainactivity.PingActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/15 10:46
 *用途：
 */
class QuanApaters extends BaseQuickAdapter<Users, BaseViewHolder> {

    public QuanApaters(@Nullable List<Users> data) {
        super(R.layout.quaniter, data);
        addChildClickViewIds(R.id.qupingquan);

    }
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Users user) {
        //修改刷新数据
        UserRoom userRoom = UserDataBase.getInstance(getContext()).getUserRoom();

        //边角圆形
        ImageView view = baseViewHolder.getView(R.id.simgquan);
        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background).bitmapTransform(new RoundedCorners(30));//图片圆角为30
        Glide.with(getContext()).load(user.getPics()) //图片地址
                .apply(options)
                .into(view);
        baseViewHolder.setText(R.id.smingquan,user.getNames());
        baseViewHolder.setText(R.id.ssmingquan,user.getNames());
        baseViewHolder.setText(R.id.gtvquan,""+user.getPrices()+"￥");
        TextView textView = baseViewHolder.getView(R.id.qupingquan);

        //数据库创建一个方法  通过下标来判断下方的方法
        if (user.getState()==0){
            textView.setText("去支付");
        }else if (user.getState()==1){
            textView.setText("确认收货");
        }else if (user.getState()==2){
                textView.setText("去评价");
        }else if (user.getState()==3) {
            textView.setText("已评价");
        }
        //创建一个集合来传数组
        ArrayList<Users> list = new ArrayList<>();
        list.add(user);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getState()==0){
                    //跳转支付
                    ARouter.getInstance().build("/pay/pay").withSerializable("ints",list).navigation();
                }else if (user.getState()==1){
                    //确认收货
                    user.setState(2);
                    userRoom.updata(user);
                    notifyItemChanged(baseViewHolder.getPosition());
                }else{
                    //跳转评价
                    ARouter.getInstance().build("/for/for")
                      .withSerializable("us",user)
                       .navigation();
                }
            }
        });

    }
}

