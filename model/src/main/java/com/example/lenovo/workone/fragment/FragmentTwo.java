package com.example.lenovo.workone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.ZhanActivity;

/**
 * Created by lenovo on 2017/12/15.
 */

public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_two, null);
        startActivity(new Intent(getActivity(), ZhanActivity.class));
        return view;


    }
}
