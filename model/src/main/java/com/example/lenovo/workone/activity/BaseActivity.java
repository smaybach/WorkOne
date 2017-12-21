package com.example.lenovo.workone.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.lenovo.workone.presenter.IPresenter;

/**
 * Created by lenovo on 2017/12/16.
 */

public abstract class BaseActivity<T extends IPresenter> extends Fragment {
    T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        complatepresenter();
    }

    protected abstract void complatepresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
