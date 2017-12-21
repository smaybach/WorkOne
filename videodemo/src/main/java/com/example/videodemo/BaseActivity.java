package com.example.videodemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.videodemo.presenter.IPresenter;

/**
 * Created by lenovo on 2017/12/20.
 */

public abstract class BaseActivity<T extends IPresenter> extends Activity {
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complatepresenter();
    }

    protected abstract void complatepresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
