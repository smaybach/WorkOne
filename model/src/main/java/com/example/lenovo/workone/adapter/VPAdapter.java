package com.example.lenovo.workone.adapter;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by lenovo on 2017/12/16.
 */

public class VPAdapter extends PagerAdapter {
    private List<ImageView> imageList;
    private Handler handler;
    public VPAdapter(List<ImageView> imageList, Handler handler) {
        this.imageList = imageList;
        this.handler = handler;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = imageList.get(position%imageList.size());
        //点击图片的时停止轮播
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_CANCEL://鼠标划走
                        //发送信息
                        handler.sendEmptyMessageDelayed(1, 2000);
                        break;
                    case MotionEvent.ACTION_DOWN://鼠标按下
                        //清空所有handler消息池的信息及所有毁掉函数
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case MotionEvent.ACTION_UP://鼠标抬起
                        //发送信息
                        handler.sendEmptyMessageDelayed(1, 2000);
                        break;
                }


                return true;
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }
}

