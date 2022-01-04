package com.bawei.home.jomejson.api;

import com.bawei.home.jomejson.json.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:20
 *用途：
 */
interface Api {
    @Headers("Authorization:bearer g4a9FSo-n3AqRMMEaOO45N805e134eK5lVCAgx946Lv6QDpv7OXv2u2I_zCTj9db_001MQ8hhDDlRuZuk98S6pxSlCdjZcgc-WgWCN0jN6ymzsjr62CSsGttBZrCz-znm0cbewp9Q-a5J5R3FbfrxWDCnYecuISdGRcC8qAKopj65NMDX47lEGukUykaK46ZqX4Q6NXTuG5xVrt24jU8Hlgs78YrJLaLSu4872vBDHFB-nNli4TiLCRSmDwRzXWz-GBndY4DHmbH8r_MSukPn8zSOQvitib-1_B95esUjR4")
    @GET("api/Goods/getGoods?")
    Observable<FoodBean> getData(@Query("keyword") String name, @Query("type") String type, @Query("pageno")Integer pageno, @Query("pagesize")Integer pagesize);
}
