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

public class ModifyPasswordActivity extends Activity {


    private EditText old_password,new_password;
    private Button submit_password;


    private String userAccount;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_password);
        initView();

    }


    private void initView(){
        old_password=(EditText)findViewById(R.id.old_password);
        new_password=(EditText)findViewById(R.id.new_password);
        submit_password=(Button)findViewById(R.id.submit_password);

        submit_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (old_password==null||old_password.getText().toString().isEmpty()){
                    ToastUtil.show(ModifyPasswordActivity.this,"请输入您原来的密码");
                }

                System.out.println("年后");

                if (new_password==null||new_password.getText().toString().isEmpty()){
                    ToastUtil.show(ModifyPasswordActivity.this,"请输入新的密码");
                }



                //如果上面的要求都符合的话就可以向服务器发送请求了
                sendRequest();

            }
        });

    }


    private void sendRequest(){
        JSONObject jsonObject=new JSONObject();

        try {
            jsonObject.put(constant.REQUEST_TYPE,constant.MODIFY_PASSWORD);
            jsonObject.put(constant.OLD_PASSWORD,old_password.getText().toString());
            jsonObject.put(constant.NEW_PASSWORD,new_password.getText().toString());
            jsonObject.put(constant.USER_ACCOUNT,userAccount);
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
                        ToastUtil.show(ModifyPasswordActivity.this,"密码修改成功！");
                    }else{
                        ToastUtil.show(ModifyPasswordActivity.this,"密码修改失败，请稍候重试");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail(String result) {
                ToastUtil.show(ModifyPasswordActivity.this,"密码修改失败，请稍候重试");
            }
        },jsonObject);

    }


}
