package com.dream.rxjavademo.entity;

/**
 * Created by Administrator on 2018/3/25.
 */

public class BaseResponseEntity<T> {
    private int code;
    private String msg;
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getCode() {
        return code;

    }

    public String getMsg() {
        return msg;
    }

    public boolean isSucc(){
        return code == 0;
    }
}
