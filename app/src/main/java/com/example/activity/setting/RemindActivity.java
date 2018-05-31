package com.example.activity.setting;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

public class RemindActivity extends Activity{

    LSettingItem remind,not_disturb_time,time_interval,remind_music;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_remind);
        findView();
        reactToClick();
    }

    private void findView(){
        remind=(LSettingItem)findViewById(R.id.shut_down_remind);
        not_disturb_time=(LSettingItem)findViewById(R.id.not_disturb_time);
        time_interval=(LSettingItem)findViewById(R.id.time_interval);
        remind_music=(LSettingItem)findViewById(R.id.remind_music);
    }

    /**
     * 对click事件作出反应
     */
    private void reactToClick(){
        remind.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了暂时不提醒");
            }
        });


        not_disturb_time.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了设置免打扰时间");
            }
        });

        time_interval.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了设置提醒时间");
            }
        });

        remind_music.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了设置提醒音乐");
            }
        });
    }
}
