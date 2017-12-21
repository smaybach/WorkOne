package com.example.cardemo.presenter;

import com.example.cardemo.bean.CartBean;
import com.example.cardemo.model.CarModel;
import com.example.cardemo.model.ICarModel;
import com.example.cardemo.view.CarView;

import java.lang.ref.SoftReference;

/**
 * Created by lenovo on 2017/12/19.
 */

public class CarPresenter implements IPresenter<CarView> {
    ICarModel model;
    SoftReference<CarView> reference;
    public CarPresenter(CarView view){
        attach(view);
        model=new CarModel();
    }
    @Override
    public void attach(CarView view) {
        reference=new SoftReference<CarView>(view);
    }

    @Override
    public void detach() {
        reference.clear();

    }
    public void showcar(){
        model.carmodel(new ICarModel.Recy() {
            @Override
            public void complate(CartBean bean) {
                reference.get().carview(bean);
            }
        });
    }


}
