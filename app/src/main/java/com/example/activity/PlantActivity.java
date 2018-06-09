package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        Intent intent=getIntent();
//        String imgId=intent.getStringExtra("imgId");
        String plantName=intent.getStringExtra("plantName");
        position= Integer.parseInt(intent.getStringExtra("position"));
        System.out.println("植物名为"+plantName+"点击的行数："+position);

        findView();

    }


    private void findView(){
//        position= Integer.parseInt(getIntent().getStringExtra("position"));
//        System.out.println("caonc曹尼玛"+position);



        //植物的详细图片
        plant_detail_img=(ImageButton)findViewById(R.id.plant_detail_img);
        //动态更新图片
        Bitmap bitmap = null;
        switch (position){
            case 0:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant1);
                break;
            case 1:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant2);
                break;
            case 2:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant3);
                break;
            case 3:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant4);
                break;
            case 4:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant5);
                break;
            case 5:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant6);
                break;
            case 6:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant7);
                break;
            case 7:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant8);
                break;
            case 8:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant9);
                break;
            case 9:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant10);
                break;
            case 10:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant11);
                break;
            case 11:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant12);
                break;
            case 12:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant13);
                break;
            case 13:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant14);
                break;
            case 14:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant15);
                break;
            case 15:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant16);
                break;
            case 16:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant17);
                break;
            case 17:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant18);
                break;
            case 18:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant19);
                break;
            case 19:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant20);
                break;
            case 20:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant21);
                break;
            case 21:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant22);
                break;
            default:
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant1);
                break;
        }
//        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.plant1);

        plant_detail_img.setImageBitmap(bitmap);
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
