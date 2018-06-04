package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidproject_plant.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ConservationRecordAdapter;
import entity.ConservationRecord;

/**
 * 控制养护信息总的显示界面
 */
public class ConservationRecordActivity extends Activity {

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
}
