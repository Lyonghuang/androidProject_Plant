package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidproject_plant.R;

import net.HttpMethod;
import net.NetConnection;

import org.json.JSONException;
import org.json.JSONObject;

import constatnt.constant;
import util.ToastUtil;

public class AddPlantActivity extends Activity{

    private EditText input_name,input_date,plant_type;
    private Button add_plant;

    private JSONObject json;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_plant);

        initView();
    }


    private void initView(){
        input_name=(EditText)findViewById(R.id.input_name);
        input_date=(EditText)findViewById(R.id.input_date);
        plant_type=(EditText)findViewById(R.id.plant_type);



        add_plant=(Button)findViewById(R.id.add_plant);

        add_plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    json.put(constant.PLANT_NAME,input_name.getText().toString());
                    json.put(constant.PLANT_DATE,input_date.getText().toString());
                    json.put(constant.PLANT_TYPE,plant_type.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                addPlant(input_name.getText().toString(),input_date.getText().toString(),plant_type.getText().toString());
            }
        });
    }



    private void addPlant(String plantName,String plantDate,String plantType){
        new NetConnection(constant.URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                ToastUtil.show(AddPlantActivity.this,"添加成功");
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail(String result) {
                ToastUtil.show(AddPlantActivity.this,"添加失败，请稍后重试");

            }
        },json);
    }
}
