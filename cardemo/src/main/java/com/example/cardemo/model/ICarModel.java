package com.example.cardemo.model;

import com.example.cardemo.bean.CartBean;

/**
 * Created by lenovo on 2017/12/19.
 */

public interface ICarModel {
    public void carmodel(Recy recy);
    interface Recy{
        void complate(CartBean bean);
    }
}
