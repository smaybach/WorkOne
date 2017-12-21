package com.example.lenovo.workone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.BaseActivity;
import com.example.lenovo.workone.adapter.RecyAdapter;
import com.example.lenovo.workone.bean.UserBean;
import com.example.lenovo.workone.presenter.RecyPresenter;
import com.example.lenovo.workone.view.IRecyView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/15.
 */

public class Fragment7 extends BaseActivity<RecyPresenter> implements IRecyView {

    @Bind(R.id.rlv2)
    RecyclerView rlv2;
    private RecyPresenter presenter;
    private RecyAdapter recyAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment3, null);
        ButterKnife.bind(this, view);
        presenter.showPresenter();

        return view;
    }
    @Override
    public void recyView(UserBean bean) {
        rlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyAdapter = new RecyAdapter(getActivity(), bean);
        rlv2.setAdapter(recyAdapter);
    }

    @Override
    protected void complatepresenter() {
        presenter = new RecyPresenter(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

