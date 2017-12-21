package com.example.lenovo.workone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.lenovo.workone.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/12/15.
 */

public class FragmentThree extends Fragment {

    @Bind(R.id.yanpiao)
    ImageView yanpiao;
    private RadioGroup rg;
    public ViewPager vp;
    private List<Fragment> listF = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_three, null);
        //找控件
        vp = view.findViewById(R.id.gl_topvp);
        rg = view.findViewById(R.id.rg_top);
        initData();
        MyFpAdapter adapter = new MyFpAdapter(getFragmentManager());
        vp.setAdapter(adapter);
        //点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.fb_bm:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.fb_fb:
                        vp.setCurrentItem(1);
                        break;
                    default:
                        break;
                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg.check(R.id.fb_bm);
                        break;
                    case 1:
                        rg.check(R.id.fb_fb);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

    private void initData() {
        listF.add(new FragmentThree1());
        listF.add(new FragmentThree2());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.yanpiao)
    public void onViewClicked() {
        startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
    }

    //创建一个适配器
    class MyFpAdapter extends FragmentPagerAdapter {

        public MyFpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listF.get(position);
        }

        @Override
        public int getCount() {
            return listF.size();
        }
    }

}
