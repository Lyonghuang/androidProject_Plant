package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject_plant.R;

import util.ToastUtil;

public class RegisterActivity extends Activity implements View.OnClickListener{


    private EditText userName,input_password,check_password;
    private Button register;

    private String first_in_put_password,second_inout_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findView();
    }


    private void findView(){
        userName=(EditText)findViewById(R.id.userName);
        input_password=(EditText)findViewById(R.id.input_password);
        check_password=(EditText)findViewById(R.id.check_password);


        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    /**
     * 判断两次输入的密码是否相同
     * @return
     */
    private boolean passwordEqual(){
        first_in_put_password=input_password.getText().toString();
        second_inout_password=check_password.getText().toString();
        return first_in_put_password.equals(second_inout_password);
    }

    /**
     * 在数据库中查询手机号已经被注册
     * @param v
     */


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                ToastUtil.show(this,"进行注册");
                break;
        }
    }
}
