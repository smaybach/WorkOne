package com.example.lenovo.workone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.workone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/15.
 */

public class FragmentThree1 extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragm_1,null);
        //找控件
        mTabLayout = view.findViewById(R.id.tl_1);
        mViewPager = view.findViewById(R.id.vp_1);
        initData();
        return view;
    }

    private void initData() {
        listTitles = new ArrayList<>();
        fragments = new ArrayList<>();
        listTextViews = new ArrayList<>();

        listTitles.add("待审核");
        listTitles.add("待支付");
        listTitles.add("待参加");
        listTitles.add("已完成");
        for (int i = 0; i < listTitles.size(); i++) {
            ContentFragment fragment = ContentFragment.newInstance(listTitles.get(i));
            fragments.add(fragment);

        }
        //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
        for (int i=0;i<listTitles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(listTitles.get(i)));//添加tab选项
        }

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
//                if (position==0){
//                    Fragment2 fragment2 = new Fragment2();
//                    return fragment2;
//                }


                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            }
            @Override
            public int getCount() {
                return fragments.size();
            }
            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }
}
