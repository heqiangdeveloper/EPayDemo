package com.cimcitech.epaydemo;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.pay_bt)
    Button pay_Bt;
    @Bind(R.id.pay_rg)
    RadioGroup pay_Rg;

    private String payMethod = "wechat";
    private IWXAPI api;
    private final int SDK_PAY_FLAG = 1;
    private String resultStatus;
    private String result;
    private String memo;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SDK_PAY_FLAG:
                    Map<String,String> payResult = (Map<String,String>)msg.obj;
                    resultStatus = payResult.get("resultStatus");
                    result = payResult.get("result");
                    memo = payResult.get("memo");
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    // 判断resultStatus 为非“9000”则代表可能支付失败
                    // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，
                    // 最终交易是否成功以服务端异步通知为准（小概率状态）
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(MainActivity.this, "支付成功",Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.equals(resultStatus, "8000")) {
                        Toast.makeText(MainActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();
                    } else {// 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                        Toast.makeText(MainActivity.this, "支付失败",Toast.LENGTH_SHORT).show();
                    }
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        api = WXAPIFactory.createWXAPI(MainActivity.this, null);
        // 将该app注册到微信
        api.registerApp("wxd930ea5d5a258f4f");
        initView();
    }

    public void initView(){
        pay_Rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.view_wechat_pay:
                        payMethod = "wechat";
                        break;
                    case R.id.view_alipay_pay:
                        payMethod = "alipay";
                        break;
                }
            }
        });
    }

    @OnClick({R.id.pay_bt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.pay_bt:
                //从商家后台获取订单信息
                getBillData();
                break;
        }
    }

    //检测是否安装微信
    private boolean weChatPayIsSupported() {
        boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
        return isPaySupported;
    }

    public void getBillData(){
        OkHttpUtils
                .post()
                .url(Config.propertyPay)
                .addParams("token", Config.token)
                .addParams("identify", "mTerminal")
                .addParams("chargeInfoId", "1")//应缴费用基本信息ID
                .addParams("ptRoomId", "17")//房间ID
                .addParams("chargeOfMonth", "2017-09")//费用所属月份
                .addParams("payMethod", payMethod)//支付方式
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try{
                            JSONObject jo1 = new JSONObject(response);
                            String status = jo1.getString("status");
                            if(status.equals("1")){//成功
                                String data = jo1.getString("data");
                                JSONObject jo2 = new JSONObject(data);
                                String orderInfo = jo2.getString("orderInfo");
                                JSONObject jo3 = new JSONObject(orderInfo);
                                if(payMethod.equals("wechat")){
                                    if(weChatPayIsSupported()){
                                        callWechatPay(jo3);
                                    }else{
                                        Toast.makeText(MainActivity.this,"不支持微信支付",Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    aliPay(orderInfo);
                                }
                            }
                        }catch (JSONException e){

                        }
                    }
                });

    }

    public void callWechatPay(JSONObject jo){
        PayReq request = new PayReq();
        try{
            request.appId = jo.getString("appid");
            request.partnerId = jo.getString("partnerid");
            request.prepayId= jo.getString("prepayid");
            request.packageValue = jo.getString("package");
            request.nonceStr= jo.getString("noncestr");
            request.timeStamp= jo.getString("timestamp");
            request.sign= jo.getString("sign");
            api.sendReq(request);
        }catch (Exception e){
            //nothing
        }
    }

    public void aliPay(final String orderInfo){
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(MainActivity.this);
                Map<String,String> result = alipay.payV2(orderInfo,true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
