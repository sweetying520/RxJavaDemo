package com.dream.rxjavademo;

import com.dream.rxjavademo.entity.RecommendEntity;
import com.dream.rxjavademo.entity.ShopCartEntity;
import com.dream.rxjavademo.entity.Translation1;
import com.dream.rxjavademo.entity.Translation2;
import com.dream.rxjavademo.entity.UserInfoEntity;
import com.dream.rxjavademo.http.BaseResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
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
    Observable<BaseResponse<UserInfoEntity>> login(@QueryMap Map<String,String> loginParams);

    @GET("appapi/cart/getCartInfo")
    Observable<BaseResponse<List<ShopCartEntity>>> getShopCart();

    @GET("appapi/customer/logout")
    Observable<BaseResponse<Object>> loginOut();

    @GET("appapi/customer/status")
    Observable<BaseResponse<Object>> checkUser();

    @GET("appapi/index/deal/?cmd=featured_products&page=1&limit=5")
    Observable<BaseResponse<List<RecommendEntity>>> getHome();






}
