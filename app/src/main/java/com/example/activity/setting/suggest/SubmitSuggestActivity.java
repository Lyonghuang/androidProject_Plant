package com.example.activity.setting.suggest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject_plant.R;

import util.ToastUtil;

public class SubmitSuggestActivity extends Activity{


    private Button submit;
    private EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_suggset);

        et=(EditText)findViewById(R.id.input_suggest);

        submit=(Button)findViewById(R.id.submit_suggest);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(SubmitSuggestActivity.this,"您的意见已成功提交，感谢您的建议！");
                et.setText("");
                for (int i=0;i<10000;i++);
                finish();
            }
        });
    }
}
