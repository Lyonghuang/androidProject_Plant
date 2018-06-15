package com.example.activity.setting;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidproject_plant.R;

import java.util.ArrayList;
import java.util.List;

import adapter.PlantAdapter;
import entity.Plant;
import util.ToastUtil;

public class CollectionsActivity extends Activity {

    private RecyclerView plantRecyclerView;
    private PlantAdapter plantAdapter;
    private List<Plant> plants=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_collections);



    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }


    private void initView(){
        if (plants.size()>0){
            return;
        }
        plantRecyclerView=(RecyclerView)findViewById(R.id.collectionsPlant);
        initPlant();

        plantRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        plantAdapter=new PlantAdapter(this,plants);

        plantRecyclerView.setAdapter(plantAdapter);

        plantAdapter=new PlantAdapter(this,plants);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);

        //设置布局管理器
        plantRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adaapter
        plantRecyclerView.setAdapter(plantAdapter);
        //设置增加或删除条目的动画
        plantRecyclerView.setItemAnimator(new DefaultItemAnimator());


        plantAdapter.setOnItemClickListener(new PlantAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.show(CollectionsActivity.this,"您点击了第"+position+"行");

//                Intent intent=new Intent(CollectionsActivity.this, PlantActivity.class);
//                startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {
                ToastUtil.show(CollectionsActivity.this,"您长按了第 "+position+"行");
            }
        });


        plantRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            public void onScrolled(RecyclerView recyclerView,int dx,int dy){
                super.onScrolled(recyclerView,dx,dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                switch (newState){
                    case 0:
                        if (isSlideToBottom(recyclerView)){
//                            ToastUtil.show(CollectionsActivity.this,"隐藏导航栏");
//                            ((MainActivity)getActivity()).hide();
                        }else{
//                            ToastUtil.show(CollectionsActivity.this,"显示导航栏");
                        }
                        break;

                }
            }
        });

    }

    private void initPlant(){
//        ArrayList xianrenzhang=new ArrayList();
//        Plant plant=new Plant("仙人掌");
//        plant.setId(1);//植物ID
//        plant.setLowTemperature(10);//生长的最低温度
//        plant.setHighTemperature(40);//生长的最高温度
//        plant.setDescription("这个仙人掌很好养活");//植物描述
//        plant.setLignt("喜欢阳光，请多晒太阳");//植物生长的光照
//        plant.setBaikeURL("www.pdfcxc.cn");//有关该植物的链接
//        plants.add(plant);

//        plants.add(new Plant("植物1",R.drawable.plant_1,"生长状态良好"));
//        plants.add(new Plant("植物2",R.drawable.plant_2,"生长状态良好"));
//        plants.add(new Plant("植物3",R.drawable.plant_3,"生长状态良好"));
//        plants.add(new Plant("植物4",R.drawable.plant_4,"生长状态良好"));
//        plants.add(new Plant("植物5",R.drawable.plant_5,"生长状态良好"));
//        plants.add(new Plant("植物6",R.drawable.plant_6,"生长状态良好"));
//        plants.add(new Plant("植物7",R.drawable.plant_7,"生长状态良好"));
//        plants.add(new Plant("植物8",R.drawable.plant_8,"生长状态良好"));
//        plants.add(new Plant("植物9",R.drawable.plant_9,"生长状态良好"));
//        plants.add(new Plant("植物10",R.drawable.plant_10,"生长状态良好"));
//        plants.add(new Plant("植物11",R.drawable.plant_11,"生长状态良好"));
//        plants.add(new Plant("植物12",R.drawable.plant_12,"生长状态良好"));
//        plants.add(new Plant("植物13",R.drawable.plant_13,"生长状态良好"));
//        plants.add(new Plant("植物14",R.drawable.plant_14,"生长状态良好"));
        plants.add(new Plant("鸿运当头",R.drawable.plant21,"生长状态良好"));
        plants.add(new Plant("龟背竹",R.drawable.plant22,"生长状态良好"));
        plants.add(new Plant("银皇后",R.drawable.plant19,"生长状态良好"));
        plants.add(new Plant("芦荟",R.drawable.plant15,"生长状态良好"));
        plants.add(new Plant("文竹",R.drawable.plant9,"生长状态良好"));
        plants.add(new Plant("君子兰",R.drawable.plant4,"生长状态良好"));
        plants.add(new Plant("发财树",R.drawable.plant2,"生长状态良好"));


    }


    protected boolean isSlideToBottom(RecyclerView recyclerView){
        if (recyclerView==null){
            return false;
        }
        if (recyclerView.computeVerticalScrollExtent()+recyclerView.computeHorizontalScrollExtent()
                >= recyclerView.computeVerticalScrollRange()){
            return true;
        }
        return false;

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
