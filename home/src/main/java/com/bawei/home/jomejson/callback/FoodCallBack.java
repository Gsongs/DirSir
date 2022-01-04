package com.bawei.home.jomejson.callback;

import com.bawei.home.jomejson.json.FoodBean;

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
