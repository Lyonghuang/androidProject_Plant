package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.androidproject_plant.R;

import util.ToastUtil;

public class ConservationActivity extends Activity implements View.OnClickListener{

    private Button finish_conservation;
    private Button how_to_conservation;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conservation);


    }

    private void findView(){
        finish_conservation=(Button)findViewById(R.id.finish_conservation);
        finish_conservation.setOnClickListener(this);

        how_to_conservation=(Button)findViewById(R.id.how_to_conservation);
        how_to_conservation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_conservation:
                ToastUtil.show(this,"您已经完成了养护操作");
                break;
            case R.id.how_to_conservation:
                ToastUtil.show(this,"点击这个您可以查看如何进行养护");
                break;
        }
    }
}
