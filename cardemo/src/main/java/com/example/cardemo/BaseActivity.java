package com.example.cardemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.cardemo.presenter.IPresenter;

/**
 * Created by lenovo on 2017/12/19.
 */

public abstract class BaseActivity<T extends IPresenter> extends Activity {
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        complataPresenter();
    }

    protected abstract void complataPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
