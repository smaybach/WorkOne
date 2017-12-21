package com.example.videodemo.presenter;

/**
 * Created by lenovo on 2017/12/20.
 */

public interface IPresenter<T> {
    void attach(T view);
    void detach();
}
