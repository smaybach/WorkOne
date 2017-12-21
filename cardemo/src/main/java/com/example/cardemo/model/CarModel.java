package com.example.cardemo.model;

import com.example.cardemo.bean.CartBean;
import com.example.cardemo.inter.Service;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/19.
 */

public class CarModel implements ICarModel {
    @Override
    public void carmodel(final Recy recy) {
        Service.API_SERVICE.getdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CartBean bean) {
                        CartBean bean1 = bean;
                        recy.complate(bean1);
                    }
                });
    }
}
