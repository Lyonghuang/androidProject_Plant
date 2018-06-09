package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.activity.AddPlantActivity;
import com.example.activity.PlantActivity;
import com.example.androidproject_plant.R;

import java.util.ArrayList;
import java.util.List;

import adapter.PlantAdapter;
import entity.Plant;
import util.ToastUtil;

public class PlantFragment extends Fragment{

    private RecyclerView plantRecyclerView;
    private PlantAdapter plantAdapter;
    private List<Plant> plants=new ArrayList<>();

    private ImageButton addPlant;

    private View view;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


//        View view=inflater.inflate(R.layout.activity_plant,container,false);
        view=inflater.inflate(R.layout.fragment_plant,container,false);

        return view;
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

        addPlant=(ImageButton)view.findViewById(R.id.add_plant_button);
        addPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddPlantActivity.class);
                startActivity(intent);
            }
        });


        plantRecyclerView=(RecyclerView)view.findViewById(R.id.recylerViewPlant);
        initPlant();

        plantRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        plantAdapter=new PlantAdapter(getContext(),plants);

        plantRecyclerView.setAdapter(plantAdapter);

        plantAdapter=new PlantAdapter(getContext(),plants);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());

        //设置布局管理器
        plantRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adaapter
        plantRecyclerView.setAdapter(plantAdapter);
        //设置增加或删除条目的动画
        plantRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //添加分默认的割线
        plantRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        plantAdapter.setOnItemClickListener(new PlantAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.show(getActivity(),"您点击了第"+position+"行");

                Intent intent=new Intent(getActivity(), PlantActivity.class);


                System.out.println("植物id为："+plants.get(position).getImgId());
//                intent.putExtra("imgId",plants.get(position).getImgId()+"");
                intent.putExtra("plantName",plants.get(position).getName());
                intent.putExtra("position",position+"");
                System.out.println("王尼玛： "+position);
                startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {
                ToastUtil.show(getActivity(),"您长按了第 "+position+"行");
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
                            ToastUtil.show(getActivity(),"隐藏导航栏");
//                            ((MainActivity)getActivity()).hide();
                        }else{
                            ToastUtil.show(getActivity(),"显示导航栏");
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
//        plant.setLignt("喜欢阳光，请多晒太阳");//植物生长的光照l
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



        plants.add(new Plant("变叶木",R.drawable.plant3,"生长状态良好"));
        plants.add(new Plant("太阳神",R.drawable.plant5,"生长状态良好"));
        plants.add(new Plant("富贵竹",R.drawable.plant6,"生长状态良好"));
        plants.add(new Plant("小天使蔓绿绒",R.drawable.plant7,"生长状态良好"));
        plants.add(new Plant("常春藤",R.drawable.plant8,"生长状态良好"));
        plants.add(new Plant("滴水观音",R.drawable.plant10,"生长状态良好"));
        plants.add(new Plant("玛丽安",R.drawable.plant11,"生长状态良好"));
        plants.add(new Plant("琴叶榕",R.drawable.plant12,"生长状态良好"));
        plants.add(new Plant("红掌",R.drawable.plant13,"生长状态良好"));
        plants.add(new Plant("绿萝",R.drawable.plant14,"生长状态良好"));
        plants.add(new Plant("虎皮兰",R.drawable.plant16,"生长状态良好"));
        plants.add(new Plant("袖珍椰子",R.drawable.plant17,"生长状态良好"));
        plants.add(new Plant("金钱树",R.drawable.plant18,"生长状态良好"));
        plants.add(new Plant("马蹄莲",R.drawable.plant20,"生长状态良好"));
        plants.add(new Plant("仙人掌",R.drawable.plant1,"生长状态良好"));




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
