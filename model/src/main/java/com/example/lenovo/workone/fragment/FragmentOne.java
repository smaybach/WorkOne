package com.example.lenovo.workone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.workone.activity.CictyActivity;
import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.MainActivity;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
//import android.support.design.widget.TabLayout;
/**
 * Created by lenovo on 2017/12/15.
 */
public class FragmentOne extends Fragment {
    private ViewPager vp_pager;                             //定义viewPager
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private List<Fragment> list_fragment = new ArrayList<Fragment>();                                //定义要装fragment的列表
    private String[] title={"全部","综艺娱乐","财经访谈","青少科教","养生保健","文化旅游","史上体育","公益"};
    private TabLayout tab_title;
    private LinearLayout layou;
    private TextView quan;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_one, null);
        tab_title = view.findViewById(R.id.tab_FindFragment_title);
        vp_pager = (ViewPager)view.findViewById(R.id.vp_FindFragment_pager);
        layou = view.findViewById(R.id.layout);
        quan = view.findViewById(R.id.quan);
        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });
        return view;
    }
    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city1 = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                quan.setText("当前选择：" + city1);
            }
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyAdapter adapter=new MyAdapter(getChildFragmentManager());
        initControls();
        tab_title.setupWithViewPager(vp_pager);
        vp_pager.setAdapter(adapter);
        tab_title.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
    private void initControls() {
        //将fragment装进列表中
        list_fragment.add(new Fragment1());
        list_fragment.add(new Fragment2());
        list_fragment.add(new Fragment3());
        list_fragment.add(new Fragment4());
        list_fragment.add(new Fragment5());
        list_fragment.add(new Fragment6());
        list_fragment.add(new Fragment7());
        list_fragment.add(new Fragment8());
    }
    private void initFragment() {
        for (int i = 0; i < 3; i++) {
            list_fragment.add(new Fragment2());
        }
    }
    class MyAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragmentList;
        public MyAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }
        @Override
        public int getCount() {
            return list_fragment.size();
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);

        }
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
