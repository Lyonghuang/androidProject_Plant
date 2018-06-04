package com.example.activity.setting.account;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject_plant.R;

import net.HttpMethod;
import net.NetConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import constatnt.constant;
import util.ToastUtil;

public class ModifyTelActivity extends Activity {


    private EditText old_tel, new_tel;
    private Button submit_tel;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_tel);


    }


    private void initView(){
        old_tel =(EditText)findViewById(R.id.old_tel);
        new_tel =(EditText)findViewById(R.id.new_tel);
        submit_tel =(Button)findViewById(R.id.submit_tel);

        submit_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (old_tel ==null|| old_tel.getText().toString().isEmpty()){
                    ToastUtil.show(ModifyTelActivity.this,"请输入您原来的手机号码");
                }

                if (new_tel ==null|| new_tel.getText().toString().isEmpty()){
                    ToastUtil.show(ModifyTelActivity.this,"请输入新的手机号码");
                }



                //如果上面的要求都符合的话就可以向服务器发送请求了
                sendRequest();

            }
        });

    }


    private void sendRequest(){
        JSONObject jsonObject=new JSONObject();

        try {
            jsonObject.put(constant.REQUEST_TYPE,constant.MODIFY_TEL);
            jsonObject.put(constant.OLD_TEL, old_tel.getText().toString());
            jsonObject.put(constant.NEW_TEL, new_tel.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new NetConnection(constant.URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {

                try {
                    JSONObject json=new JSONObject(result);
                    JSONArray jsonArray=json.getJSONArray(constant.RESPONSE);
                    String response=jsonArray.getJSONObject(0).getString(constant.STATUS_CODE);

                    if (response.equals("200")){
                        ToastUtil.show(ModifyTelActivity.this,"手机号码修改成功！");
                    }else{
                        ToastUtil.show(ModifyTelActivity.this,"手机号码修改失败，请稍候重试");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail(String result) {
                ToastUtil.show(ModifyTelActivity.this,"手机号码修改失败，请稍候重试");
            }
        },jsonObject);

    }

}
