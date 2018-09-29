package com.cimcitech.epaydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.cimcitech.epaydemo.bean.LoginVo;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by qianghe on 2018/9/29.
 */

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.name_et)
    EditText name_Et;
    @Bind(R.id.psw_et)
    EditText psw_Et;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
    }

    public void initView(){
        name_Et.setText("15768616002");
        psw_Et.setText("15768616002");
    }

    @OnClick({R.id.login_bt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_bt:
                login();
                break;
        }
    }

    public void login(){
        OkHttpUtils
                .post()
                .url(Config.POST_LOGIN)
                .addParams("telephone",name_Et.getText().toString().trim())
                .addParams("password",psw_Et.getText().toString().trim())
                .addParams("identify", "mTerminal")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LoginVo loginVo = new Gson().fromJson(response,LoginVo.class);
                        if(null != loginVo){
                            if(loginVo.getStatus().equals("1")){
                                Config.token = loginVo.getData().getAccessToken();
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                finish();
                            }
                        }
                    }
                });

    }
}
