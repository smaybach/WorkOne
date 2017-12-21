package com.example.lenovo.workone.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/12/15.
 */

public class FragmentFour extends Fragment {


    @Bind(R.id.wd_sz)
    ImageView wdSz;
//    @Bind(R.id.liu)
//    LinearLayout liu;
//    @Bind(R.id.heng)
//    LinearLayout heng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_four, null);

//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            title.setText(bundle.getString("trim"));
//        }
        LinearLayout liu=view.findViewById(R.id.liu);
        LinearLayout heng=view.findViewById(R.id.heng);



        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);


        if (sp.getBoolean("isLogin", false)) {

            liu.setVisibility(View.GONE);
            heng.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), "已登录", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "为登录", Toast.LENGTH_SHORT).show();
            heng .setVisibility(View.GONE);
            liu.setVisibility(View.VISIBLE);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.wd_sz)
    public void onViewClicked() {



        Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);


    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }
//
//
//    @OnClick({R.id.wd_xx, R.id.wd_sz})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.wd_xx:
//                Toast.makeText(getActivity(), "点击消息", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.wd_sz:
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }


}
