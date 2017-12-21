
package com.example.lenovo.workone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.workone.R;

public class ZhanActivity extends AppCompatActivity {
    public RadioGroup zhan_rg;
    public ImageView zhan_black;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhan);
        //找控件
        zhan_rg = findViewById(R.id.zhan_rg);
        zhan_black = findViewById(R.id.zhan_black);
        //d点击事件
        zhan_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.zhan_hd:
                        //跳转
                        Intent intent = new Intent(ZhanActivity.this, Huo_Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.zhan_jq:
                        //吐司
                        Toast.makeText(ZhanActivity.this,"敬请期待->谢谢",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        //点击退出
        zhan_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZhanActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
