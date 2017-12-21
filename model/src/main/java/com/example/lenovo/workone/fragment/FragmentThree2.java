package com.example.lenovo.workone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.bean.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/15.
 */

public class FragmentThree2 extends Fragment {

    public ListView f2_rv;
    private List<Util> ls;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragm_2,null);
        //找控件
        f2_rv = view.findViewById(R.id.f2_lv);
        //创建一个集合
        ls = new ArrayList<Util>();
        //数据
        for (int i = 0; i < 50; i++) {
            Util util = new Util();
            util.setTu(R.mipmap.a);
            util.setNamel("欢迎您的到来！"+i);
            util.setContent("2017-12-"+i);
            ls.add(util);
        }
        MyAdapter adapter = new MyAdapter();
        f2_rv.setAdapter(adapter);
        return view;
    }
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ls.size();
        }

        @Override
        public Object getItem(int i) {
            return ls.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHorld horld = null;
            if(view == null){
                view = View.inflate(getActivity(), R.layout.f2_litm, null);
                horld = new ViewHorld();
                horld.imageView = (ImageView) view.findViewById(R.id.im);
                horld.textView1 = (TextView) view.findViewById(R.id.tv_name);
                horld.textView2 = (TextView) view.findViewById(R.id.tv_con);
                view.setTag(horld);
            }else{
                horld = (ViewHorld) view.getTag();
            }
            //设置数据
            horld.imageView.setImageResource(ls.get(i).getTu());
            horld.textView1.setText(ls.get(i).getNamel());
            horld.textView2.setText(ls.get(i).getContent());
            return view;
        }
    }
    class ViewHorld{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}
