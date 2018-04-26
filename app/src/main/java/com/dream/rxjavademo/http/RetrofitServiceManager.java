package com.dream.rxjavademo.http;

import android.os.Environment;

import com.dream.rxjavademo.common.ApiService;
import com.dream.rxjavademo.App;
import com.dream.rxjavademo.http.interceptor.CommonParamsInterceptor;
import com.dream.rxjavademo.http.interceptor.HttpCacheInterceptor;
import com.dream.rxjavademo.http.interceptor.HttpHeaderInterceptor;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2018/3/24.
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 10;//超时时间
    private static final int DEFAULT_READ_TIME_OUT = 10;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 10;//读取时间
    private Retrofit mRetrofit;


    private RetrofitServiceManager(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIME_OUT,TimeUnit.SECONDS);


        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(App.getInstance())));

        addInterceptor(builder);


        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(ApiService.BASR_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 添加各种拦截器
     * @param builder
     */
    private void addInterceptor(OkHttpClient.Builder builder) {
        // 添加日志拦截器，非debug模式不打印任何日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpHeaderInterceptor httpHeaderInterceptor = new HttpHeaderInterceptor.Builder().build();
        HttpCacheInterceptor httpCacheInterceptor = new HttpCacheInterceptor();
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(httpHeaderInterceptor);
        builder.addInterceptor(new CommonParamsInterceptor());
        builder.addInterceptor(httpCacheInterceptor);
        builder.addNetworkInterceptor(httpCacheInterceptor);
        builder.cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/RxJavaDemo"),1024*1024*10));

    }

    private static class SingletonHolder{
        private static RetrofitServiceManager retrofitServiceManager = new RetrofitServiceManager();
    }

    public static RetrofitServiceManager getInstance(){
        return SingletonHolder.retrofitServiceManager;
    }

    public <T> T creat(Class<T> tClass){
        return mRetrofit.create(tClass);
    }

}
