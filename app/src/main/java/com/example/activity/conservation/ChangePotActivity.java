package com.example.activity.conservation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidproject_plant.R;

import constatnt.constant;
import util.ToastUtil;

public class ChangePotActivity extends Activity implements View.OnClickListener{

    private String finish_water="完成换盆";
    private String how_to_water="如何换盆？";
    private String conservation="换盆";

    private Button finish_conservation;
    private Button how_to_conservation;
    private TextView conservation_text;


    //要从本地获取plantId和nickName
    private String plantId;
    private String nickName;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conservation);
        findView();

    }


    private void findView(){
        finish_conservation=(Button)findViewById(R.id.finish_conservation);
        finish_conservation.setText(finish_water);
        finish_conservation.setOnClickListener(this);

        how_to_conservation=(Button)findViewById(R.id.how_to_conservation);
        how_to_conservation.setText(how_to_water);
        how_to_conservation.setOnClickListener(this);

        conservation_text=(TextView)findViewById(R.id.conservation_text);
        conservation_text.setText(conservation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_conservation:
                new SendConservationFinish(ChangePotActivity.this,plantId,nickName, constant.CHANGE_FLOWER_POT);
//                ToastUtil.show(this,"完成换盆！");
                break;
            case R.id.how_to_conservation:
                ToastUtil.show(this,"将要展示的页面告诉你如何进行换盆！");
                break;
        }
    }



}
