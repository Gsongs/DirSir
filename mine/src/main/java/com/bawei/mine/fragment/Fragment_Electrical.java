package com.bawei.mine.fragment;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.mine.R;
import com.bawei.mine.collter.FoodCollter;
import com.bawei.mine.json.FoodBean;
import com.bawei.mine.main.Details_onr;
import com.bawei.mine.model.FoodModel;
import com.bawei.mine.mydapater.Fragment_oneApter;
import com.bawei.mine.presenter.FoodPresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 09:35
 *用途：
 */
class Fragment_Electrical extends BaseFragment implements FoodCollter.FoodView {
    private RecyclerView resfive;
    FoodPresenter foodPresenter;
    String page1 = "家用电器", page2 = "家用电器";
    Integer page3 = 25, page4 = 25;
    List<String> smallImages;
    @Override
    public int bandLayout() {
        return R.layout.fragment_fivea
                ;
    }

    @Override
    public void initView() {

        resfive = (RecyclerView) findViewById(R.id.resfive);



        resfive.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        foodPresenter = new FoodPresenter(new FoodModel(), this);
    }

    @Override
    public void initData() {
        foodPresenter.doGet(page1,page2,page3,page4);
    }

    @Override
    public void FoodModels(List<FoodBean.DataBean> foodBeans) {
        Fragment_oneApter apter = new Fragment_oneApter(foodBeans);
        resfive.setAdapter(apter);
        apter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                Intent intent = new Intent(getActivity(), Details_onr.class);
                intent.putExtra("pic",foodBeans.get(position).getPictUrl());
                intent.putExtra("name",foodBeans.get(position).getTitle());
                intent.putExtra("num",foodBeans.get(position).getShopDsr());
                intent.putExtra("dian",foodBeans.get(position).getShopTitle());
                intent.putExtra("yifu",foodBeans.get(position).getCouponInfo());
                intent.putExtra("num1",foodBeans.get(position).getCommissionRate());
                intent.putStringArrayListExtra("imgview11", (ArrayList<String>) foodBeans.get(position).getSmallImages());



                startActivity(intent);
            }
        });
    }

    @Override
    public void shot(@NotNull String msg) {

    }
}
