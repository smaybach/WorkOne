package com.example.lenovo.workone.presenter;

import com.example.lenovo.workone.bean.UserBean;
import com.example.lenovo.workone.model.IRecyModel;
import com.example.lenovo.workone.model.RecyModel;
import com.example.lenovo.workone.view.IRecyView;

import java.lang.ref.SoftReference;

/**
 * Created by lenovo on 2017/12/16.
 */

public class RecyPresenter implements IPresenter<IRecyView> {
    IRecyModel model;
    SoftReference<IRecyView> recyViewSoftReference;

    public RecyPresenter(IRecyView view){
        attach(view);
        model=new RecyModel();
    }


    @Override
    public void attach(IRecyView view) {
        recyViewSoftReference=new SoftReference<IRecyView>(view);
    }

    @Override
    public void detach() {
        recyViewSoftReference.clear();
    }
    public void showPresenter(){
        model.recymodel(new IRecyModel.Recy() {
            @Override
            public void complate(UserBean bean) {
                recyViewSoftReference.get().recyView(bean);
            }
        });
    }

}
