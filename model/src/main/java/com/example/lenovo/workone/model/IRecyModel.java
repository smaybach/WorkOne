package com.example.lenovo.workone.model;

import com.example.lenovo.workone.bean.UserBean;

/**
 * Created by lenovo on 2017/12/16.
 */

public interface IRecyModel {
    public  void recymodel(Recy recy);
    interface Recy{
        void complate(UserBean bean);
    }

}
