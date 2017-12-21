package com.example.lenovo.workone.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.workone.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegActivity extends AppCompatActivity {

    @Bind(R.id.log_fh)
    ImageView logFh;
    @Bind(R.id.btn_hqyz)
    Button btnHqyz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.log_fh, R.id.btn_hqyz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.log_fh:
                finish();
                break;
            case R.id.btn_hqyz:

                break;
        }
    }
}
