package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidproject_plant.R;

import net.HttpMethod;
import net.NetConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.ConservationRecordAdapter;
import constatnt.constant;
import entity.ConservationRecord;

/**
 * 控制养护信息总的显示界面
 */
public class ConservationRecordActivity extends Activity {

    //需要从本地获取plantId
    private String plantId;

    private ConservationRecordAdapter conservationRecordAdapter;
    private List<ConservationRecord> conservationRecords=new ArrayList<>();
    private RecyclerView conservationRecordView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conservation_log);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initView();
    }

    private void initView(){

        if (conservationRecords.size()>0){
            return;
        }
        conservationRecordView =(RecyclerView)findViewById(R.id.conservation_record);

        initConservationRecord();

        conservationRecordView.setLayoutManager(new LinearLayoutManager(this));

        conservationRecordAdapter=new ConservationRecordAdapter(this,conservationRecords);

        conservationRecordView.setAdapter(conservationRecordAdapter);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        conservationRecordView.setLayoutManager(layoutManager);
        conservationRecordView.setAdapter(conservationRecordAdapter);


    }


    private void initConservationRecord(){
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","习近平"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭丽媛"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","奥巴马"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("施肥","2018.05.23","伊丽莎白"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("换盆","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","威廉王子"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("施肥","2018.05.23","金正恩"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","彭敦福"));
        conservationRecords.add(new ConservationRecord("浇水","2018.05.23","胡锦涛"));
        conservationRecords.add(new ConservationRecord("繁殖","2018.05.23","江泽明"));
        conservationRecords.add(new ConservationRecord("施肥","2018.05.23","彭敦福"));
    }


    /**
     * 从服务器获取某个植物的养护记录
     */
    private void getData(){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put(constant.REQUEST_TYPE,constant.GET_CONSERVATION_RECORDS);
            jsonObject.put(constant.PLANT_ID,plantId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new NetConnection(constant.URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject json=new JSONObject(result);
                    JSONArray jsonArray=json.getJSONArray(constant.RESPONSE);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject data=jsonArray.getJSONObject(i);
                        conservationRecords.add(new ConservationRecord(constant.CONSERVATION_ACTION,
                                constant.CONSERVATION_TIME,constant.CONSERVATION_PERSON));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail(String result) {
                System.out.println("获取信息失败");
            }
        },jsonObject);
    }


}
