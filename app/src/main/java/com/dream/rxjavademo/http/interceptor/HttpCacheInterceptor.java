package com.dream.rxjavademo.http.interceptor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dream.rxjavademo.App;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/24.
 */

public class HttpCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // 无网络时，始终使用本地Cache
        if (!isValidNetWork()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);
        if (isValidNetWork()) {
            // 有网络时，设置缓存过期时间0个小时
            int maxAge = 0;
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        } else {
            // 无网络时，设置缓存过期超时时间为4周
            int maxStale = 60 * 60 * 24 * 28;
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }

    /**
     * 当前网络是否有效
     *
     * @return true:可用 false:不可用
     */
    public static boolean isValidNetWork() {
        ConnectivityManager nw = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = nw.getActiveNetworkInfo();
        if (netinfo != null && netinfo.isAvailable() && netinfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}

