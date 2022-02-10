package com.sandeep.github01.retrofit;

public interface CustomCallbackRetrofit<T> {
    void onSuccess(T object,String tag);
    void onFailure(T object,String tag);
}
