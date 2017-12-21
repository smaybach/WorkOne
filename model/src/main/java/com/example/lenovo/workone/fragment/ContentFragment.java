package com.example.lenovo.workone.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.workone.R;


/**
 * Created by 信徒° on 2017/12/15.
 */

public class ContentFragment extends Fragment {
    private View view;
    private static final String KEY = "title";
    private TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.contentfragment,null);
        tvContent =  view.findViewById(R.id.tv_content);
        String string = getArguments().getString(KEY);
        tvContent.setText(string);
        tvContent.setTextColor(Color.BLUE);
        tvContent.setTextSize(30);
        return view;
    }
    /**
     * fragment静态传值
     */
    public static ContentFragment newInstance(String str){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);

        return fragment;
    }
}