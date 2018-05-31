package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.activity.setting.AccountActivity;
import com.example.activity.setting.CollectionsActivity;
import com.example.activity.setting.RemindActivity;
import com.example.activity.setting.SuggestActivity;
import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

import widget.CircleImageView;

public class SettingFragment extends android.support.v4.app.Fragment{

    CircleImageView avator_image;
    TextView nickName;
    LSettingItem account,collection,remind,suggest;

    FragmentManager fragmentManager;

    public SettingFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_setting,container,false);
//        initFragment();

        //UI Object
//        try {
//            avator_image=view.findViewById(R.id.avator_image);
//        }catch (Exception e){
//            System.out.println("错误："+e.getCause());
//        }
        nickName=(TextView)view.findViewById(R.id.nick_name);//昵称id
        account=(LSettingItem)view.findViewById(R.id.account);//账户id
        collection=(LSettingItem)view.findViewById(R.id.collection);//收藏id
        remind=(LSettingItem)view.findViewById(R.id.shut_down_remind);//提醒id
        suggest=(LSettingItem)view.findViewById(R.id.suggest);//建议id

        //        avator_image.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
//            @Override
//            public void click() {
//                ToastUtil.show(SettingActivity.this,"点击了头像");
//            }
//        });

//        avator_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("点击了头像");
//            }
//        });


        nickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击昵称");
            }
        });

        account.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击账号");
                Intent intent=new Intent(getActivity(), AccountActivity.class);
                startActivity(intent);

            }
        });

        collection.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击收藏");
                Intent intent=new Intent(getActivity(), CollectionsActivity.class);
                startActivity(intent);

            }
        });

        remind.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击提醒");
                Intent intent=new Intent(getActivity(), RemindActivity.class);
                startActivity(intent);

            }
        });

        suggest.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击反馈与建议");
                Intent intent=new Intent(getActivity(), SuggestActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

//    private void initFragment(){
//        SettingFragment settingFragment=new SettingFragment();
//        fragmentManager=getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.home_container,settingFragment).commit();
//    }

    @Override
    public void onPause() {
        super.onPause();

    }



    @Override
    public void onResume() {
// TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            System.out.println("不可见");

        } else {
            System.out.println("当前可见");
        }
    }
}
