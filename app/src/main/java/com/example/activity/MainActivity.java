package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.androidproject_plant.R;

import java.util.ArrayList;
import java.util.List;

import constatnt.constant;
import fragment.PlantFragment;
import fragment.SearchFragment;
import fragment.SettingFragment;


public class MainActivity extends AppCompatActivity {


    private List<Fragment> fragmentList=new ArrayList<>();
    private List<String> fragmentTitle=new ArrayList<>();

    private ViewPager viewPager;

    private android.support.v4.app.FragmentManager fragmentManager;


    private LinearLayout login;//登录界面
    private LinearLayout setting;//设置界面
    private LinearLayout search;//搜索界面
    private LinearLayout chat;//聊天界面


    private RelativeLayout home_container;
    private RelativeLayout main;

    private BottomNavigationBar bottom_navigation_bar;
    //    private LinearLayout fl_content;
    private BadgeItem badge;
    private Activity activity;

//    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);


        initFragment();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

//        new RemindUtil(10*60,"浇水",this);


        findView();
        initBottomNavigationBar();


    }


    //由相应的id找到对应的view
    public void findView() {
        login = (LinearLayout) findViewById(R.id.login);
        setting = (LinearLayout) findViewById(R.id.settingFragment);
        search=(LinearLayout)findViewById(R.id.searchFragment);
        chat=(LinearLayout)findViewById(R.id.chatFragment);
        main=(RelativeLayout)findViewById(R.id.main);

//        home_container=(LinearLayout)findViewById(R.id.home_container);
        bottom_navigation_bar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

    }


    /**
     * 初始化刚进入app的界面
     */
    private void initFragment(){
//        SettingFragment settingFragment=new SettingFragment();
//        fragmentList.add(settingFragment);
//        fragmentTitle.add("setting");

        PlantFragment plantFragment=new PlantFragment();
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.home_container,plantFragment).commit();
    }

    public void initViewPager(){
//        viewPager=(ViewPager)findViewById(R.id.)
    }


    //获取当前点击的是哪个页面
    public int getSelectedPosition(int selectedPosition) {
//        ToastUtil.show(this,"当前选择的是"+selectedPosition);
        changeView(selectedPosition);
        return selectedPosition;
    }

    //获取当前离开的是哪个页面
    public int getUnSelectedPosition(int unSelectedPosition) {
//        ToastUtil.show(this,"当前选择的是"+unSelectedPosition);
        return unSelectedPosition;
    }


    //使当前点击的页面可见，离开的页面不可见
    public void setViewVisible(int selectedPosition,int unSelectedPosition){

    }

    //将点击的页面展示出来，将其他的页面隐藏
    public void changeView(int selectedPosition) {


        switch (selectedPosition) {
            case constant.PLANT:
                PlantFragment plantFragment=new PlantFragment();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.home_container,plantFragment).commit();

//                ToastUtil.show(this, "已经切换到了home界面");
                break;
            case constant.CHAT:


//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

//                ChatFragment chatFragment=new ChatFragment();
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.home_container,chatFragment).commit();
                Intent intent=new Intent(MainActivity.this,ChatActivity.class);
                startActivity(intent);


                //隐藏导航栏
//                hide(getCurrentFocus());//隐藏掉下面的导航栏

//                ToastUtil.show(this, "已经切换到了chat界面");
                break;
            case constant.SEARCH:

                SearchFragment searchFragment=new SearchFragment();
                fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.home_container,searchFragment).commit();


//                ToastUtil.show(this, "已经切换到了search界面");
                break;
            case constant.SETTING:
//
                SettingFragment settingFragment=new SettingFragment();
                System.out.println("你好"+settingFragment.isVisible());
                fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_container,settingFragment).commit();
                System.out.println("你好"+settingFragment.isVisible());

//                ToastUtil.show(this, "已经切换到了setting界面");
                break;
        }
    }

    /**
     * 重置所有文本的选中状态
     */


    private void initBottomNavigationBar() {

        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //设置默认颜色
        bottom_navigation_bar
                .setInActiveColor(R.color.tv_gray_deep)//设置未选中的Item的颜色，包括图片和文字
                .setActiveColor(R.color.backgroundColor)
                .setBarBackgroundColor(R.color.orange_light);//设置整个控件的背景色
        //设置徽章
        badge = new BadgeItem()
//                .setBorderWidth(2)//Badge的Border(边界)宽度
//                .setBorderColor("#FF0000")//Badge的Border颜色
//                .setBackgroundColor("#000")//Badge背景颜色
//                .setGravity(Gravity.RIGHT| Gravity.TOP)//位置，默认右上角
                .setText("2")//显示的文本
//                .setTextColor("#F0F8FF")//文本颜色
//                .setAnimationDuration(2000)
//                .setHideOnSelect(true)//当选中状态时消失，非选中状态显示
        ;
        //添加选项
        bottom_navigation_bar.addItem(
//                new BottomNavigationItem(R.mipmap.ic_directions_run_white_24dp, "步行"))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_bike_white_24dp, "骑行").setBadgeItem(badge))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_local_airport_black_24dp, "公交"))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_car_white_24dp, "自驾"))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_directions_railway_white_24dp, "火车"))
                new BottomNavigationItem(R.mipmap.plant1,"花园"))
                .addItem(new BottomNavigationItem(R.mipmap.chat6,"聊天"))
                .addItem(new BottomNavigationItem(R.mipmap.search3,"发现"))
                .addItem(new BottomNavigationItem(R.mipmap.me2,"我"))
                .initialise();//初始化BottomNavigationButton,所有设置需在调用该方法前完成
        bottom_navigation_bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                getSelectedPosition(position);//返回选中的导航栏位置
                System.out.println("选中界面："+position);
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中
                getUnSelectedPosition(position);
                System.out.println("不选中："+position);
            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中
            }
        });

    }


    /**
     * 隐藏导航栏
     * @param view
     */
    public void hide(View view){
        bottom_navigation_bar.hide();
    }

    /**
     * 显示导航栏
     * @param view
     */
    public void show(View view){
        bottom_navigation_bar.unHide();
        badge.toggle();
        Snackbar.make(bottom_navigation_bar,"你好啊",Snackbar.LENGTH_SHORT).show();
    }
//
//
//
//    private void findView(){
//        fl_content = (LinearLayout) findViewById(R.id.fl_content);
//        bottom_navigation_bar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//    }


//    public void login(View view) {
//        startActivity(new Intent(this,LoginActivity.class));
//
//    }
//
//    public void setting(View view){
//        startActivity(new Intent(this,SettingActivity.class));
//    }

//    public void bottom(View view){
//        startActivity(new Intent(this,BottomActivity.class));
//    }

    public void exit(View view) {
        finish();
    }
}
