package com.dream.rxjavademo.http.interceptor;

import com.dream.rxjavademo.http.listener.RetrofitDownloadListener;
import com.dream.rxjavademo.http.responsebody.RetrofitResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/6/22.
 */

public class RetrofitDownloadInterceptor implements Interceptor{

    private RetrofitDownloadListener downloadListener;

    public RetrofitDownloadInterceptor(RetrofitDownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(
                new RetrofitResponseBody(response.body(), downloadListener)).build();
    }
}
