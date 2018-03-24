package com.dream.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dream.rxjavademo.entity.ShopCartEntity;
import com.dream.rxjavademo.entity.UserInfoEntity;
import com.dream.rxjavademo.http.RetrofitServiceManager;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnGetShopCart;
    private Button btnLogout;
    private Button btnStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        btnGetShopCart = findViewById(R.id.btn_get_shop_cart);
        btnLogout = findViewById(R.id.btn_log_out);
        btnStatus = findViewById(R.id.btn_status);
        btnLogout.setOnClickListener(this);
        btnStatus.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnGetShopCart.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Map<String, String> loginParams = new HashMap<>();
                loginParams.put("username","1770385837@qq.com");
                loginParams.put("password","erdai666");
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .login(loginParams)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<UserInfoEntity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(UserInfoEntity value) {
                                Log.d("print", "-->" + value);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("print", "-->" + e);
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            case R.id.btn_get_shop_cart:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .getShopCart()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ShopCartEntity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ShopCartEntity value) {
                                Log.d("print", "-->" + value);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("print", "-->" + e);
                            }

                            @Override
                            public void onComplete() {

                            }
                });
                break;
            case R.id.btn_log_out:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .loginOut()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(String value) {
                                Log.d("print", "-->" + value);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            case R.id.btn_status:

                break;
        }
    }
}
