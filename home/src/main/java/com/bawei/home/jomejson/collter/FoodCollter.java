package com.bawei.home.jomejson.collter;

import com.bawei.home.jomejson.callback.FoodCallBack;
import com.bawei.home.jomejson.json.FoodBean;
import com.bawei.library_mvp.model.IModel;
import com.bawei.library_mvp.view.IView;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:28
 *用途：
 */
interface FoodCollter {
    interface FoodModel extends IModel {
        void FoodModels(String page1, String page2, Integer page3, Integer page4, FoodCallBack callBack);
    }

    interface FoodView extends IView {
        void FoodModels(List<FoodBean.DataBean> foodBeans);
    }
}
