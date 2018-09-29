package com.cimcitech.epaydemo.wxapi;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cimcitech.epaydemo.Config;
import com.cimcitech.epaydemo.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by qianghe on 2018/9/28.
 */

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @Bind(R.id.code_tv)
    TextView code_Tv;
    @Bind(R.id.close_bt)
    Button close_Bt;

    private IWXAPI api;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_pay_result);
        ButterKnife.bind(this);

        api = WXAPIFactory.createWXAPI(this, Config.wxAPPID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @OnClick({R.id.close_bt})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.close_bt:
                finish();
                break;
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if(baseResp.getType()== ConstantsAPI.COMMAND_PAY_BY_WX){
            if(baseResp.errCode == 0){//成功
                code_Tv.setText("成功");
            }else if(baseResp.errCode == -1){//错误
                code_Tv.setText("错误");
            }else if(baseResp.errCode == -2){//用户取消
                code_Tv.setText("用户取消");
            }
        }
    }
}
