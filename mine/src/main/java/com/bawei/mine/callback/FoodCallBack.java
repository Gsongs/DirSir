package com.bawei.mine.callback;

import com.bawei.library_mvp.model.IModel;
import com.bawei.library_mvp.view.IView;
import com.bawei.mine.json.FoodBean;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:26
 *用途：
 */
interface FoodCallBack {

    void success(List<FoodBean.DataBean> foodBeans);

}
