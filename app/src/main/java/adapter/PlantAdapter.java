package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject_plant.R;

import java.util.List;

import entity.Plant;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder>{

    private Context context;
    private List<Plant> plants;
    private LayoutInflater inflater;

    private OnItemClickListener onItemClickListener;



    public PlantAdapter(Context context,List<Plant> plants){
        this.context=context;
        this.plants=plants;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }


    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(PlantViewHolder holder, final int position) {
        Plant plant = null;
        for (int i=0;i<plants.size();i++){
            plant=plants.get(position);
        }


        //设置植物的图片和名字
        holder.imageView.setImageResource(plant.getImgId());
        holder.plantName.setText(plant.getName());
        holder.plantStatus.setText(plant.getDescription());


        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
    }


    //加载布局
    @Override
    public PlantAdapter.PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.plant,parent,false);
        PlantViewHolder holder=new PlantViewHolder(view);
        return holder;
    }





    class PlantViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;
        TextView plantName;
        TextView plantStatus;


        public PlantViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.plant_img);
            plantName =(TextView)view.findViewById(R.id.plant_name);
            plantStatus=(TextView)view.findViewById(R.id.plant_status);


        }
    }


    public interface OnItemClickListener{
        void onClick(int position);
        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


//        //自定义点击事件和长按事件
//    private AdapterView.OnItemClickListener onItemClickListener;
//    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener){
//        this.onItemClickListener=onItemClickListener;
//    }
//
//    //设置点击事件
//    private void setClickListener(final PlantViewHolder holder,int position){
//        if (onItemClickListener!=null){
//            holder.itemView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    int pos=holder.getLayoutPosition();
//                    onItemClickListener.onItemClick(holder.itemView,pos);
//                }
//            });
//        }
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
//
//            @Override
//            public boolean onLongClick(View v) {
//                int pos=holder.getLayoutPosition();
//                onItemClickListener.onItemClick(holder.itemView,pos);
//                return true;
//            }
//        });
//    }
}


//import android.content.Context;
//import android.media.Image;
//import android.support.v7.widget.RecyclerView;
//import android.text.Layout;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import java.util.List;
//
//import entity.Plant;
//
//public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder>{
//
//
//
//
//
//
//    @Override
//    public PlantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(PlantAdapter.PlantViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
