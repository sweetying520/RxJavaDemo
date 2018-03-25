package com.dream.rxjavademo;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dream.rxjavademo.entity.RecommendEntity;
import com.dream.rxjavademo.entity.ShopCartEntity;
import com.dream.rxjavademo.entity.UserInfoEntity;
import com.dream.rxjavademo.http.BaseResponse;
import com.dream.rxjavademo.http.RetrofitServiceManager;
import com.dream.rxjavademo.http.RxjavaHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnGetShopCart;
    private Button btnLogout;
    private Button btnStatus;
    private Button btnRecommend;

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnGetShopCart = findViewById(R.id.btn_get_shop_cart);
        btnLogout = findViewById(R.id.btn_log_out);
        btnStatus = findViewById(R.id.btn_status);
        btnRecommend = findViewById(R.id.btn_recommend);
        btnLogout.setOnClickListener(this);
        btnStatus.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnGetShopCart.setOnClickListener(this);
        btnRecommend.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
                        .compose(RxjavaHelper.<BaseResponse<UserInfoEntity>>observeOnMainThread())
                        .subscribe(new RxSubcriber<UserInfoEntity>(this) {
                            @Override
                            public void onSuccess(UserInfoEntity userInfoEntity) {
                                Log.d("print", "-0->" + userInfoEntity.getEmail());
                            }
                        });
                break;
            case R.id.btn_get_shop_cart:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .getShopCart()
                        .compose(RxjavaHelper.<BaseResponse<List<ShopCartEntity>>>observeOnMainThread())
                        .subscribe(new RxSubcriber<List<ShopCartEntity>>(this) {
                            @Override
                            public void onSuccess(List<ShopCartEntity> shopCartEntity) {

                            }
                        });
                break;
            case R.id.btn_log_out:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .loginOut()
                        .compose(RxjavaHelper.<BaseResponse<Object>>observeOnMainThread())
                        .subscribe(new RxSubcriber<Object>(this) {

                            @Override
                            public void onSuccess(Object o) {

                                Log.d("print", "str " + o);
                            }
                        });
                break;
            case R.id.btn_status:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .checkUser()
                        .compose(RxjavaHelper.<BaseResponse<Object>>observeOnMainThread())
                        .subscribe(new RxSubcriber<Object>(this) {

                            @Override
                            public void onSuccess(Object o) {

                                Log.d("print", "str checkUser" + o);
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                            }
                        });
                break;
            case R.id.btn_recommend:
                RetrofitServiceManager.getInstance().creat(ApiService.class)
                        .getHome()
                        .compose(RxjavaHelper.<BaseResponse<List<RecommendEntity>>>observeOnMainThread())
                        .subscribe(new RxSubcriber<List<RecommendEntity>>(this) {
                            @Override
                            public void onSuccess(List<RecommendEntity> o) {
                                Log.d("print", "--->" + o);
                            }
                        });

                break;
        }
    }
}
