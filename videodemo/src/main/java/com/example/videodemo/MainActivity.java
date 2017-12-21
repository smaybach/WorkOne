package com.example.videodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.videodemo.adapter.MyAdapter;
import com.example.videodemo.bean.Bean;
import com.example.videodemo.bean.UserBean;
import com.example.videodemo.presenter.RecyPresenter;
import com.example.videodemo.view.IRecyView;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MainActivity extends BaseActivity<RecyPresenter> implements IRecyView {
    @Bind(R.id.jcv)
    JCVideoPlayerStandard jcv;
    @Bind(R.id.rlv)
    RecyclerView rlv;
    String s1 = "http://video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
    String s2 = "http://player.youku.com/player.php/sid/XMjUyODI2NDc2MA==/v.swf";//不支持swf格式的视频播放
    public RecyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        getSupportActionBar().setTitle("jiecaovideoplayer");
        jcv.setUp(s1,jcv.SCREEN_LAYOUT_NORMAL,"JCVideo");
        presenter.showrecy();
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void complatepresenter() {
        presenter = new RecyPresenter(this);

    }
    @Override
    public void recyview(UserBean bean) {
//        rlv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
       rlv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(this, bean);
        rlv.setAdapter(myAdapter);
    }

    @Override
    public void Xrecyview(Bean bean1) {

    }
}
