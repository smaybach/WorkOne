package com.example.lenovo.workone.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.workone.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.log_fh)
    ImageView logFh;
    @Bind(R.id.reg)
    TextView reg;
    @Bind(R.id.wangji)
    TextView wangji;
    @Bind(R.id.pohoe)
    EditText pohoe;
    @Bind(R.id.pwd)
    EditText pwd;
    @Bind(R.id.denglu)
    Button denglu;
    String phone1 = "13621052076";
    String pwd1 = "123321";
    @Bind(R.id.rlFalse)
    LinearLayout rlFalse;
    @Bind(R.id.btnZhuX)
    Button btnZhuX;
    @Bind(R.id.rlTrue)
    LinearLayout rlTrue;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        edit = sp.edit();

        btnZhuX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putBoolean("isLogin", false);
                edit.commit();
                rlTrue.setVisibility(View.GONE);
                rlFalse.setVisibility(View.VISIBLE);
            }
        });


        if (sp.getBoolean("isLogin", false)) {
            rlTrue.setVisibility(View.VISIBLE);
            rlFalse.setVisibility(View.GONE);

        } else {
            rlTrue.setVisibility(View.GONE);
            rlFalse.setVisibility(View.VISIBLE);
        }

    }



    @OnClick({R.id.log_fh, R.id.reg, R.id.wangji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.log_fh:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
//                finish();
                break;
            case R.id.reg:
                startActivity(new Intent(this, RegActivity.class));
                break;
            case R.id.wangji:
                startActivity(new Intent(this, WJActivity.class));
                break;
        }
    }

    @OnClick(R.id.denglu)
    public void onViewClicked() {
        if (pohoe.getText().toString().equals(phone1) && pwd.getText().toString().equals(pwd1)) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//            rlTrue.setVisibility(View.GONE);
            edit.putBoolean("isLogin", true);
            edit.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);


        } else {
//            rlTrue.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "账户或密码不正确", Toast.LENGTH_SHORT).show();
        }
    }
}
