package com.example.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.activity.setting.suggest.SubmitSuggestActivity;
import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

public class SuggestActivity extends Activity {

    private LSettingItem suggest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_suggest);
        findView();
        reactToClick();

    }


    private void findView(){
        suggest=(LSettingItem)findViewById(R.id.advice);
    }

    private void reactToClick(){
        suggest.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("给我们提建议");
                Intent intent=new Intent(SuggestActivity.this, SubmitSuggestActivity.class);
                startActivity(intent);

            }
        });
    }
}
