package com.dream.rxjavademo;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dream.rxjavademo.common.ApiService;
import com.dream.rxjavademo.entity.BannerEntity;
import com.dream.rxjavademo.http.BaseResponse;
import com.dream.rxjavademo.http.RetrofitServiceManager;
import com.dream.rxjavademo.http.RxSubcriber;
import com.dream.rxjavademo.http.RxjavaHelper;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends BaseActivity  {

    TextView tv;

    @Override
    protected void initView() {

        tv = findViewById(R.id.tv);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void getData(View view){
        RetrofitServiceManager.getInstance().creat(ApiService.class)
                .getBanner()
                .compose(RxjavaHelper.<BaseResponse<List<BannerEntity>>>observeOnMainThread())
                .subscribe(new RxSubcriber<List<BannerEntity>>(this) {
                    @Override
                    public void onSuccess(List<BannerEntity> bannerEntities) {
                        Log.d("print", "->" + bannerEntities.size());
                        tv.setText(bannerEntities.toString());
                    }
                });
    }



}
