package com.example.mvpsession4;

public interface ResponseCallBack <T>{
    void onSuccess(T data);
    void onError(String msg);
}
