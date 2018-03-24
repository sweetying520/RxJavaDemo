package com.dream.rxjavademo.http.interceptor;

import android.util.ArrayMap;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/24.
 */

public class CustomParamsInterceptor implements Interceptor {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        ArrayMap paramsMap = new ArrayMap();
        paramsMap.put("version", "1.0");
        paramsMap.put("token", "");
        paramsMap.put("device", "Android");
        if (request.body() instanceof FormBody) {
            FormBody oldBody = (FormBody) request.body();
            for (int i = 0; i < oldBody.size(); i++) {
                paramsMap.put(oldBody.encodedName(i), oldBody.encodedValue(i));
            }
        }
        Gson gson = new Gson();


        RequestBody body = RequestBody.create(JSON, gson.toJson(paramsMap));
        request = request.newBuilder().post(body).build();
        return chain.proceed(request);
    }

}
