package com.example.lenovo.workone.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.workone.R;
import com.example.lenovo.workone.fragment.FragmentFour;
import com.example.lenovo.workone.fragment.FragmentOne;
import com.example.lenovo.workone.fragment.FragmentThree;
import com.example.lenovo.workone.fragment.FragmentTwo;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("活动",R.mipmap.found, FragmentOne.class)
                .addTabItem("发布",R.mipmap.fancy, FragmentTwo.class)
                .addTabItem("管理",R.mipmap.special, FragmentThree.class)
                .addTabItem("我的",R.mipmap.my, FragmentFour.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });





    }
}
