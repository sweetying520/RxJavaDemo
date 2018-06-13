package com.dream.rxjavademo;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dream.rxjavademo.common.ApiService;
import com.dream.rxjavademo.entity.BannerEntity;
import com.dream.rxjavademo.http.BaseObserver;
import com.dream.rxjavademo.http.RetrofitServiceManager;
import com.dream.rxjavademo.http.RxSubcriber;
import com.dream.rxjavademo.http.RxUtils;
import com.dream.rxjavademo.http.RxjavaHelper;


import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity {

    TextView tv;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void initView() {

        tv = findViewById(R.id.tv);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void getData(View view) {
        /**
         * 方法一 由于无返回值不好管理 不推荐使用了
         */
        RetrofitServiceManager.getInstance().creat(ApiService.class)
                .getBanner()
                .compose(RxjavaHelper.observeOnMainThread())
                .subscribe(new RxSubcriber<List<BannerEntity>>(this) {
                    @Override
                    public void onSuccess(List<BannerEntity> bannerEntities) {
                        Log.d("print", "->" + bannerEntities.size());
                        tv.setText(bannerEntities.toString());
                    }
                });

        /**
         * 方法2 推荐使用  方便管理
         */
        addSubscribe(RetrofitServiceManager.getInstance().creat(ApiService.class)
                .getBanner()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<List<BannerEntity>>(this) {

                    @Override
                    protected void onSuccess(List<BannerEntity> bannerEntities) {
                        Log.d("print", "--->addSubscribe" + bannerEntities.size());
                    }
                }));



    }


    /**
     * 封装到base里面效果最佳
     * @param disposable disposable
     */
    private void addSubscribe(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }
}
