package com.bawei.sort.mainactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.sp.Preferences;
import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bawei.sort.collter.MsgCollter;
import com.bawei.sort.collter.TakeCollter;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;
import com.bawei.sort.model.TakeModel;
import com.bawei.sort.myater.MsgApaters;
import com.bawei.sort.presenter.TakePresenter;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/20 08:18
 *用途：
 */
@Route(path = "/m/m")
class Take extends BaseActivity<TakePresenter>  implements TakeCollter.TakeView {
    private android.widget.ImageView fanhui;
    private android.widget.TextView zhuce;
    private androidx.recyclerview.widget.RecyclerView restake;
    private android.widget.Button xinjian;
    private static final String TAG = "Take";
    private TextView baocun;

    @Override
    public int bandLayout() {
        return R.layout.take;
    }
    CheckBox checkBox;
    @Override
    public void initView() {

        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);
        restake = (RecyclerView) findViewById(R.id.restake);
        xinjian = (Button) findViewById(R.id.xinjian);
        restake.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        baocun = (TextView) findViewById(R.id.baocun);
    }

    @Override
    public void initData() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TakePresenter takePresenter = new TakePresenter(new TakeModel(), this);
        takePresenter.get();

        xinjian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Take.this,New_Flodel.class);
                    startActivity(intent);
                }
        });
    }
    @Override
    public void shot(@NotNull String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }


    @Override
    public void TakeViews(TakeBean takeBean) {
        List<TakeBean.DataBean> data = takeBean.getData();
        MsgApaters apaters=new MsgApaters(data);
        restake.setAdapter(apaters);
        apaters.notifyDataSetChanged();

        apaters.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                if (view.getId() == R.id.del) {
                    data.remove(position);
                    apaters.notifyDataSetChanged();
                    ToastUtils.showShort("删除成功");
                }
                if (view.getId() == R.id.chabox) {
                    checkBox = (CheckBox) apaters.getViewByPosition(position, R.id.chabox);
                   //sp=存储id值
                    Preferences.getInstance().put("is",data.get(position).getId());

                    apaters.notifyDataSetChanged();

                }
            }
        });
    }
}
