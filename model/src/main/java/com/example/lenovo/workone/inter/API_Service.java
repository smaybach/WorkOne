package com.example.lenovo.workone.inter;

import com.example.lenovo.workone.bean.UserBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lenovo on 2017/12/16.
 */

public interface API_Service {

    @GET("ad/getAd")
    Observable<UserBean> getdata();
    Retrofit RETROFIT=new Retrofit.Builder()
            .baseUrl(API.URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    API_Service API_SERVICE=RETROFIT.create(API_Service.class);



}
