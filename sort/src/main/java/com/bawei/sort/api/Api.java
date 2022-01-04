package com.bawei.sort.api;

import com.bawei.sort.json.LogBean;
import com.bawei.sort.json.LoginBean;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:20
 *用途：
 */
interface Api {

    @POST("user/register")
    @FormUrlEncoded
    Observable<LogBean> reg(
          @Field("username")String username,
          @Field("password")String password,
          @Field("repassword")String repassword
    );

    @POST("user/login")
    @FormUrlEncoded
    Observable<LogBean> login(
            @Field("username")String username,
            @Field("password")String password
    );

    //登录
    @Headers({"content-length:135","content-type:application/json","Authorization:bearer HtK8Oc8J3dyOrup-zT0dwgZCwZ9XLoJKrgd3RYypgehjzTFEEfIVkodaXhlFxd1bkqX3eRzz3WbVQYEBZGJZh_5Q8M2IQVJKpfeseXQxOsGet5QnEqoB8iCHV4LN3AdzHupZ0i18JXe67lIAVzO5k0THuXGa4mgo1_CWNZT_7LPOffCxRB1mRdYhQPlHcwf3pIZntWmAAyBxg5S2s8ilJ7bmMXVVFFScUP8B-Z3ofeuFKKV1je3SfIAnWVElXyWHdQ9RQpbhYWBPRBv7-vLEg7igT3gto3RO6NudoxnyhUc"})
    @POST("api/User/login")
    Observable<LoginBean> getLogin(@Body LoginBean.DataBean loginBean);

    //查询地址
    @Headers("Authorization:bearer I90yjPetzZPiHpZCd44d8l-3p54bg-zXYbs8-7mMozW39JMfql-clCEy2CuCopoTqP6hl8b-ihSpJwL8gYxH-4twf-V14K7iloaGDZcuzqZ93uGul4PlZtlk1MUtOFGOgBLnyt85VYw77XA0H4ZEYkoCLd0YnktEaPetvZA0XIpYyFcnHS8RhcLSpYY3AJjLyR6u7Lj2MkGcEyl3AcueOdxFcxA1vr2CLtMK-gXqvIhAZtSanJ0k28BkvI9lyHLgL4QWMNsVGbuZnVHa6RJLaAxF6-rLcCfs1OscSdGyvKY")
    @GET("api/BaseAddress/getAddressByUserId?userid=2766")
    Observable<TakeBean> take_Data();

    //添加地址
    @Headers({"content-length:176","content-type:application/json","Authorization:bearer V2KweB4-XpBmlRdLfOda0ekED1idUm34sOAHVVTSE7pxmohtwsnpYNjsown3phk4DlZy1Yv26JMe6CGahzuh6hmUKhhASCR6lwGmqX-svJIazt3-DzeUDcnVD5f7Guwcj9YJJ6juzVq0U-hXUu2zvCk1kcSuPCUbYoHgoplu3jmm4O13AHesPLBgHx4_UNwj0cdgHc2xaTPppiChxQityA2WUOf0pScAob0iw36UPgsQHY9Q8e2Z9lNHcssoA7g2jU3EB7egCA5okNQXzOiB9Q9BrbLR3ESzd-hs7hBMhjM"})
    @POST("api/BaseAddress/addAddress")
    Observable<MsgBean> Getmsg(@Body MsgBean  msgBean);

}
