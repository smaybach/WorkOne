package com.example.videodemo.inter;

import com.example.videodemo.bean.Bean;
import com.example.videodemo.bean.UserBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/12/20.
 */

public interface Service {
    @GET("homePageApi/homePage.do")
    Observable<UserBean> getdata();

    @GET("videoDetailApi/videoDetail.do")
    Observable<Bean> getvideo(@Query("mediaId") String mediaId );


    Retrofit RETROFIT=new Retrofit.Builder()
            .baseUrl(API.URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Service API_SERVICE=RETROFIT.create(Service.class);
}
