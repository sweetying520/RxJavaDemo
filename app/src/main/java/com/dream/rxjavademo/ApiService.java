package com.dream.rxjavademo;

import com.dream.rxjavademo.entity.ShopCartEntity;
import com.dream.rxjavademo.entity.Translation1;
import com.dream.rxjavademo.entity.Translation2;
import com.dream.rxjavademo.entity.UserInfoEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2018/3/23.
 */

public interface ApiService {

    String BASR_URL = "http://test.bigbuy.win/";

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation1> getCall1();

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20china")
    Observable<Translation2> getCall2();


    @GET("appapi/customer/login")
    Observable<UserInfoEntity> login(@QueryMap Map<String,String> loginParams);

    @GET("appapi/cart/getCartInfo")
    Observable<ShopCartEntity> getShopCart();

    @GET("appapi/customer/logout")
    Observable<String> loginOut();

    @GET("appapi/customer/status")
    Observable<String> checkUser();





}
