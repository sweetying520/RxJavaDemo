package com.dream.rxjavademo;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.dream.rxjavademo.common.ApiService;
import com.dream.rxjavademo.entity.BannerEntity;
import com.dream.rxjavademo.http.BaseObserver;
import com.dream.rxjavademo.http.RetrofitServiceManager;
import com.dream.rxjavademo.http.RetrofitWithProgressManager;
import com.dream.rxjavademo.http.RxSubcriber;
import com.dream.rxjavademo.http.RxUtils;
import com.dream.rxjavademo.http.RxjavaHelper;
import com.dream.rxjavademo.http.listener.RetrofitDownloadListener;
import com.dream.rxjavademo.manager.ThreadPoolManager;

import java.io.InputStream;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity implements RetrofitDownloadListener {

    ImageView iv;
    TextView tv;
    NumberProgressBar mNumberProgressBar;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void initView() {
        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);
        mNumberProgressBar = findViewById(R.id.number_progress_bar);

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
     *
     * @param disposable disposable
     */
    private void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void download(View view) {
        addSubscribe(RetrofitWithProgressManager
                .getInstance(this)
                .creat(ApiService.class)
                .downLoad("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529672863611&di=e9f66a3571b06f405c6f99d0df55b954&imgtype=0&src=http%3A%2F%2Fimg.fashionmoon.com%2Fuploadfile%2F2014%2F0628%2F20140628060940275.jpg")
                .subscribeOn(Schedulers.io())
                .map(ResponseBody::byteStream)
                .observeOn(Schedulers.computation())
                .doOnNext(inputStream -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<InputStream>(this) {

                    @Override
                    protected void onSuccess(InputStream inputStream) {
                        ThreadPoolManager.getInstance().submit(() -> {
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            runOnUiThread(() -> iv.setImageBitmap(bitmap));
                        });
                    }
                })
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }

        System.exit(0);
    }


    @Override
    public void onStartDownload() {

    }

    @Override
    public void onProgress(int progress) {
        runOnUiThread(() -> {
            mNumberProgressBar.setVisibility(View.VISIBLE);
            mNumberProgressBar.setProgress(progress);
            if(progress == 100){
                mNumberProgressBar.setVisibility(View.GONE);
                Toast.makeText(baseActivity, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onFinishDownload() {

    }

    @Override
    public void onFail(String errorInfo) {

    }
}
