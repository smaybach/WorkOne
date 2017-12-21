package com.example.lenovo.workone.presenter;

/**
 * Created by lenovo on 2017/12/16.
 */

public interface IPresenter<T> {
    public  void attach(T view);
    public  void detach();
}
