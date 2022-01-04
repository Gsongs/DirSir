package com.bawei.mine.presenter;

import com.bawei.library_mvp.prsenter.BasePresenter;
import com.bawei.mine.callback.FoodCallBack;
import com.bawei.mine.collter.FoodCollter;
import com.bawei.mine.json.FoodBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 12:00
 *用途：
 */
class FoodPresenter extends BasePresenter<FoodCollter.FoodModel,FoodCollter.FoodView> {

    public FoodPresenter(@NotNull FoodCollter.FoodModel mModel, @NotNull FoodCollter.FoodView mView) {
        super(mModel, mView);



    }
    public void doGet(String page1,String page2,Integer page3,Integer page4){
            getMModel().FoodModels(page1, page2, page3, page4, new FoodCallBack() {
                @Override
                public void success(List<FoodBean.DataBean> foodBeans) {
                    getMView().FoodModels(foodBeans);
                }
            });
    }

}
