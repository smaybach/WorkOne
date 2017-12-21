package com.example.cardemo.inter;

import com.example.cardemo.bean.CartBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lenovo on 2017/12/19.
 */

public interface Service {
    @GET("getCarts?source=android&uid=71")
        Observable<CartBean> getdata();
    Retrofit RETROFIT=new Retrofit.Builder()
            .baseUrl(API.URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Service API_SERVICE=RETROFIT.create(Service.class);

}
