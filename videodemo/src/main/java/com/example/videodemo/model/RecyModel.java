package com.example.videodemo.model;

import com.example.videodemo.bean.Bean;
import com.example.videodemo.bean.UserBean;
import com.example.videodemo.inter.Service;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/20.
 */

public class RecyModel implements IRecyModel {
    @Override
    public void recymodel(final Recy recy) {
        Service.API_SERVICE.getdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserBean bean) {
                        UserBean bean1 = bean;
                        recy.complate(bean1);
                    }
                });
    }

    @Override
    public void Xrecymodel(final XRecy recy, String id) {
        Service.API_SERVICE.getvideo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        Bean bean2 = bean;
                        recy.Xcomplate(bean2);
                    }
                });

    }

}
