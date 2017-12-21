package com.example.videodemo.model;

import com.example.videodemo.bean.Bean;
import com.example.videodemo.bean.UserBean;

/**
 * Created by lenovo on 2017/12/20.
 */

public interface IRecyModel {

    void recymodel(Recy recy);
    interface Recy{
        void complate(UserBean bean);
    }
    public void Xrecymodel(XRecy recy, String id);
    interface XRecy{
        void Xcomplate(Bean bean1);
    }

}
