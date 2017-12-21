package com.example.lenovo.workone.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.BaseActivity;
import com.example.lenovo.workone.activity.LoginActivity;
import com.example.lenovo.workone.adapter.RecyAdapter;
import com.example.lenovo.workone.bean.UserBean;
import com.example.lenovo.workone.presenter.RecyPresenter;
import com.example.lenovo.workone.view.IRecyView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/15.
 */

public class Fragment2 extends BaseActivity<RecyPresenter> implements IRecyView {

    @Bind(R.id.rlv2)
    RecyclerView rlv2;
    private RecyPresenter presenter;
    private RecyAdapter recyAdapter;
    private LinearLayout ddtrue;
    private LinearLayout wwfalse;
    private Button login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment2, null);
        ButterKnife.bind(this, view);
        presenter.showPresenter();
        ddtrue = view.findViewById(R.id.dddTrue);
        wwfalse = view.findViewById(R.id.wwwFalse);
        login = view.findViewById(R.id.login);
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);


        if (sp.getBoolean("isLogin", false)) {

            wwfalse.setVisibility(View.GONE);
            ddtrue.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "已登录", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "为登录", Toast.LENGTH_SHORT).show();
            ddtrue .setVisibility(View.GONE);
            wwfalse.setVisibility(View.VISIBLE);
        }
        return view;
    }
    @Override
    public void recyView(UserBean bean) {
        rlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyAdapter = new RecyAdapter(getActivity(), bean);

        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);


        if (sp.getBoolean("isLogin", false)) {

            wwfalse.setVisibility(View.GONE);
            ddtrue.setVisibility(View.VISIBLE);
            rlv2.setAdapter(recyAdapter);
            Toast.makeText(getActivity(), "已登录", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "为登录", Toast.LENGTH_SHORT).show();
            ddtrue .setVisibility(View.GONE);
            wwfalse.setVisibility(View.VISIBLE);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
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
