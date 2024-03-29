package com.example.cardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.cardemo.adapter.RecyAdapter;
import com.example.cardemo.bean.CartBean;
import com.example.cardemo.presenter.CarPresenter;
import com.example.cardemo.view.CarView;

public class MainActivity extends BaseActivity<CarPresenter> implements CarView {
    private RecyclerView recyclerView;
    private TextView total_price;
    private TextView total_num;
    private CheckBox quanxuan;
    private RecyAdapter recyAdapter;
    private CarPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        total_price = (TextView) findViewById(R.id.total_price);
        total_num = (TextView) findViewById(R.id.total_num);
        quanxuan = (CheckBox) findViewById(R.id.quanxuan);

        quanxuan.setTag(1);//1为不选中
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        //new出适配器

        //调用presenter里面的请求数据的方法
        presenter.showcar();
        recyclerView.setLayoutManager(manager);

    }

    @Override
    protected void complataPresenter() {
        presenter = new CarPresenter(this);

    }

    @Override
    public void carview(CartBean bean) {
        recyAdapter = new RecyAdapter(this);
        recyclerView.setAdapter(recyAdapter);
        recyAdapter.add(bean);
        //调用recyAdapter里面的接口,设置 全选按钮 总价 总数量
        recyAdapter.setUpdateListener(new RecyAdapter.UpdateListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                //设置ui的改变
                total_num.setText("共"+num+"件商品");//总数量
                total_price.setText("总价 :¥"+total+"元");//总价
                if(allCheck){
                    quanxuan.setTag(2);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_selected);
                }else{
                    quanxuan.setTag(1);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_unselected);
                }
                quanxuan.setChecked(allCheck);
            }
        });
        //这里只做ui更改, 点击全选按钮,,调到adapter里面操作
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用adapter里面的方法 ,,把当前quanxuan状态传递过去

                int tag = (int) quanxuan.getTag();
                if(tag==1){
                    quanxuan.setTag(2);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_selected);
                }else{
                    quanxuan.setTag(1);
                    quanxuan.setBackgroundResource(R.drawable.shopcart_unselected);
                }

                recyAdapter.quanXuan(quanxuan.isChecked());
            }
        });


    }
}
