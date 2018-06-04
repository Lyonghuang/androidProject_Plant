package com.example.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.activity.setting.account.ModifyPasswordActivity;
import com.example.activity.setting.account.ModifyTelActivity;
import com.example.androidproject_plant.R;
import com.leon.lib.settingview.LSettingItem;

public class AccountActivity extends Activity{

    LSettingItem image,password,phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_account);
        findView();
        reatctToClick();
    }

    private void findView(){
        image=(LSettingItem)findViewById(R.id.modify_image);
        password=(LSettingItem)findViewById(R.id.modify_password);
        phone=(LSettingItem)findViewById(R.id.modify_phone);
    }

    private void reatctToClick(){
        image.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了修改头像");
            }
        });

        password.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了修改密码");
                Intent intent=new Intent(AccountActivity.this, ModifyPasswordActivity.class);
                startActivity(intent);
            }
        });

        phone.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                System.out.println("点击了修改手机号");
                Intent intent=new Intent(AccountActivity.this, ModifyTelActivity.class);
                startActivity(intent);

            }
        });
    }
}
