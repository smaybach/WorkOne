package com.example.lenovo.workone.model;

import com.example.lenovo.workone.bean.UserBean;
import com.example.lenovo.workone.inter.API_Service;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/16.
 */

public class RecyModel implements IRecyModel {
    @Override
    public void recymodel(final Recy recy) {
        API_Service.API_SERVICE.getdata()
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
}
