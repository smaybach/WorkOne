package com.example.lenovo.workone.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.activity.BaseActivity;
import com.example.lenovo.workone.adapter.RecyAdapter;
import com.example.lenovo.workone.adapter.VPAdapter;
import com.example.lenovo.workone.bean.UserBean;
import com.example.lenovo.workone.presenter.RecyPresenter;
import com.example.lenovo.workone.view.IRecyView;

import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/15.
 */

public class Fragment1 extends BaseActivity<RecyPresenter> implements IRecyView {
    private ViewPager vp;
    private List<ImageView> imageList;
    private ArrayList<ImageView> dotsList;
    private LinearLayout ll;
    private int[] images = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d};
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int currentItem = vp.getCurrentItem();
            //切换至下一个页面
            vp.setCurrentItem(++currentItem);
            //再次调用
            handler.sendEmptyMessageDelayed(1, 3000);
        }

        ;
    };
     RecyPresenter presenter;
     RecyclerView rlv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment1, null);
        ll = (LinearLayout) view.findViewById(R.id.ll);
        vp = (ViewPager) view.findViewById(R.id.vp);
        rlv = view.findViewById(R.id.rlv);
        //初始化数据
        initImages();
        //初始化小圆点
        initDots();
        VPAdapter adapter = new VPAdapter(imageList, handler);
        vp.setAdapter(adapter);
        //初始化vp的位置
        vp.setCurrentItem(imageList.size() * 1000);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//遍历小圆点集合
                for (int i = 0; i < dotsList.size(); i++) {
                    if (position % dotsList.size() == i) {//设置当前小圆点
                        dotsList.get(i).setImageResource(R.drawable.shape01);
                    } else {//设置其他小圆点
                        dotsList.get(i).setImageResource(R.drawable.shape02);
                    }
                }
                //两秒发送一个消息
                handler.sendEmptyMessageDelayed(1, 5000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    presenter.showPresenter();

        return view;
    }
    private void initDots() {
        //实例化一个集合存放小圆点
        dotsList = new ArrayList<ImageView>();
        for (int i = 0; i < images.length; i++) {
            ImageView view = new ImageView(getActivity());
            //把第一个小圆点设置为选中状态
            if (i == 0) {
                view.setImageResource(R.drawable.shape01);
            } else {
                view.setImageResource(R.drawable.shape01);
            }
            LayoutParams params = new LayoutParams(8, 8);
            //设置小圆点的边距
            params.setMargins(5, 0, 5, 0);
            //把小圆点添加到布局中
            ll.addView(view, params);
            //把小圆点添加到集合
            dotsList.add(view);
        }

    }

    private void initImages() {
        //实例化一个集合，用于存放图片
        imageList = new ArrayList<ImageView>();
        for (int i = 0; i < images.length; i++) {
            ImageView view = new ImageView(getActivity());
            view.setImageResource(images[i]);
            //添加到集合
            imageList.add(view);
        }

    }
    @Override
    public void recyView(UserBean bean) {
        RecyAdapter recyAdapter = new RecyAdapter(getActivity(), bean);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlv.setAdapter(recyAdapter);
    }
    @Override
    protected void complatepresenter() {

        presenter = new RecyPresenter(this);

    }
}
