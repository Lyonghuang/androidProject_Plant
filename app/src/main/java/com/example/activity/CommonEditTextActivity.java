package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.androidproject_plant.R;

import util.ToastUtil;


/**
 * 负责进行文字编辑
 */
public class CommonEditTextActivity extends Activity implements View.OnClickListener{

    ImageButton back;//返回按钮
    TextView edit_text;//修改文字页面的最上方显示本页功能的文字
    Button finish_button;//完成按钮
    EditText edit_text_content;//要编辑的内容

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_edit_text);

        findView();

    }


    private void findView(){
        back=(ImageButton)findViewById(R.id.back);
        back.setOnClickListener(this);

        edit_text=(TextView)findViewById(R.id.edit_text);

        finish_button=(Button)findViewById(R.id.finish_button);
        finish_button.setOnClickListener(this);

        edit_text_content=(EditText)findViewById(R.id.edit_text_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                ToastUtil.show(this,"点击返回");
                break;
            case R.id.finish_button:
                ToastUtil.show(this,"点击修改完成按钮");
                break;
        }
    }
}
