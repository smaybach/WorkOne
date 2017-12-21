package com.example.cardemo.presenter;

/**
 * Created by lenovo on 2017/12/19.
 */

public interface IPresenter<T> {
    void attach(T view);
        void detach();
}
