package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.example.activity.conservation.ChangePotActivity;
import com.example.activity.conservation.FertilizeActivity;
import com.example.activity.conservation.ReproductionActivity;
import com.example.activity.conservation.WaterActivity;
import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

import util.ToastUtil;

public class PlantActivity extends Activity{


    ImageButton plant_detail_img;//植物的照片
    LSettingItem detail_name//植物的名称
                ,plant_date//植物的种植日期
                ,water//浇水
                ,fertilize//施肥
                ,reproduction//繁殖
                ,change_pot//换盆
                ,conservation_log;//养护记录


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

        //植物的详细图片
        plant_detail_img=(ImageButton)findViewById(R.id.plant_detail_img);
        plant_detail_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //植物名称
        detail_name=(LSettingItem)findViewById(R.id.detail_name);
        detail_name.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(PlantActivity.this,CommonEditTextActivity.class);
                startActivity(intent);
            }
        });

        //种植日期
        plant_date=(LSettingItem)findViewById(R.id.plant_date);

        //浇水
        water=(LSettingItem)findViewById(R.id.water);
        water.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                ToastUtil.show(PlantActivity.this,"点击浇水");
                Intent intent=new Intent(PlantActivity.this, WaterActivity.class);
                startActivity(intent);
            }
        });

        //施肥
        fertilize=(LSettingItem)findViewById(R.id.fertilize);
        fertilize.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(PlantActivity.this, FertilizeActivity.class);
                startActivity(intent);
            }
        });

        //繁殖
        reproduction=(LSettingItem)findViewById(R.id.reproduction);
        reproduction.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(PlantActivity.this, ReproductionActivity.class);
                startActivity(intent);
            }
        });

        //换盆
        change_pot=(LSettingItem)findViewById(R.id.change_pot);
        change_pot.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(PlantActivity.this, ChangePotActivity.class);
                startActivity(intent);
            }
        });

        //养护记录
        conservation_log=(LSettingItem)findViewById(R.id.conservation_log);
        conservation_log.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent=new Intent(PlantActivity.this,ConservationRecordActivity.class);
                startActivity(intent);
            }
        });


    }
}
