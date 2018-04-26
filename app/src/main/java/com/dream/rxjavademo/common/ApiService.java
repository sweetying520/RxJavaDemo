package com.dream.rxjavademo.common;


import com.dream.rxjavademo.entity.BannerEntity;
import com.dream.rxjavademo.http.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Administrator on 2018/3/23.
 */

public interface ApiService {

    String BASR_URL = "http://test.bigbuy.win/";


    //缓存一个小时
    @Headers("Cache-Control: public, max-age=3600")
    @GET("appapi/index/banner/id/1?cmd=home_slider_top&limit=5")
    Observable<BaseResponse<List<BannerEntity>>> getBanner();

}
