package com.example.lenovo.workone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.workone.R;

public class Huo_Activity extends AppCompatActivity {
    public RadioGroup huo_yl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_);

        //找控件
        huo_yl = findViewById(R.id.huo_rg);
        //点击事件
                        huo_yl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                switch (i){
                                    case R.id.huo_yl:
                                        Toast.makeText(Huo_Activity.this,"预览",Toast.LENGTH_SHORT).show();
                                        break;
                    case R.id.huo_fb:
                        Toast.makeText(Huo_Activity.this,"发布",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
