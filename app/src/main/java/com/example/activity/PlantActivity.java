package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

import util.ToastUtil;

public class PlantActivity extends Activity implements View.OnClickListener{


    ImageButton plant_detail_img;//植物的照片
    LSettingItem detail_name//植物的名称
                ,plant_date//植物的种植日期
                ,water//浇水
                ,fertilize//施肥
                ,reproduction//繁殖
                ,change_pot;//换盆


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        findView();
        Intent intent=getIntent();
        String imgId=intent.getStringExtra("imgId");
        String plantName=intent.getStringExtra("plantName");
        ToastUtil.show(this,"植物名为"+plantName+"；图片id为"+imgId);
    }


    private void findView(){
        plant_detail_img=(ImageButton)findViewById(R.id.plant_detail_img);
        detail_name=(LSettingItem)findViewById(R.id.detail_name);
        plant_date=(LSettingItem)findViewById(R.id.plant_date);
        water=(LSettingItem)findViewById(R.id.water);
        fertilize=(LSettingItem)findViewById(R.id.fertilize);
        reproduction=(LSettingItem)findViewById(R.id.reproduction);
        change_pot=(LSettingItem)findViewById(R.id.change_pot);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_name:

                Intent intent=new Intent(PlantActivity.this,CommonEditTextActivity.class);
                startActivity(intent);
                break;
        }

    }
}
