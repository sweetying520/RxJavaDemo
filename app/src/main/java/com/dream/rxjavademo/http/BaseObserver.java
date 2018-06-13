package com.dream.rxjavademo.http;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 *
 * @author Administrator
 * @date 2018/6/13
 */

public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private String errorMsg;
    private boolean isShowErrorView;
    private Context mContext;


    public BaseObserver(Context mContext){
        this.mContext = mContext;
    }

    public BaseObserver(Context mContext,String errorMsg){
        this.mContext = mContext;
        this.errorMsg = errorMsg;
    }


    public BaseObserver(Context mContext,String errorMsg,boolean isShowErrorView){
        this.mContext = mContext;
        this.errorMsg = errorMsg;
        this.isShowErrorView = isShowErrorView;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if(!TextUtils.isEmpty(errorMsg)){
            Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();
        }else if(e instanceof ApiException){
            Toast.makeText(mContext, ((ApiException) e).getMsg(), Toast.LENGTH_SHORT).show();
        }else if(e instanceof HttpException){
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext, "未知错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);
}
