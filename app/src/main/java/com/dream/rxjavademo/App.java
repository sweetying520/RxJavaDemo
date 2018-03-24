package com.dream.rxjavademo;

import android.app.Application;

/**
 * Created by Administrator on 2018/3/24.
 */

public class App extends Application{
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static App getInstance(){
        return mApp;
    }
}
