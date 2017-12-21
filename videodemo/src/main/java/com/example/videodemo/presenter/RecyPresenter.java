package com.example.videodemo.presenter;

import com.example.videodemo.bean.Bean;
import com.example.videodemo.bean.UserBean;
import com.example.videodemo.model.IRecyModel;
import com.example.videodemo.model.RecyModel;
import com.example.videodemo.view.IRecyView;

import java.lang.ref.SoftReference;

/**
 * Created by lenovo on 2017/12/20.
 */

public class RecyPresenter implements IPresenter<IRecyView> {
    IRecyModel model;
    SoftReference<IRecyView> reference;
    public RecyPresenter(IRecyView view){
        attach(view);
        model=new RecyModel();
    }

    @Override
    public void attach(IRecyView view) {
        reference=new SoftReference<IRecyView>(view);

    }

    @Override
    public void detach() {
        reference.clear();

    }
    public void showrecy(){
        model.recymodel(new IRecyModel.Recy() {
            @Override
            public void complate(UserBean bean) {
                reference.get().recyview(bean);
            }
        });

    }
    public void Xshowrecy(String id){
     model.Xrecymodel(new IRecyModel.XRecy() {
         @Override
         public void Xcomplate(Bean bean1) {
             reference.get().Xrecyview(bean1);

         }
     },id);
    }
}
