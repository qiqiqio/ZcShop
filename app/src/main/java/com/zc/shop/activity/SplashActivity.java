package com.zc.shop.activity;

import android.content.Intent;

import com.zc.shop.R;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.utils.PreferencesUtils;


public class SplashActivity extends BaseActivity {

    @Override
    protected void init() {
        jumpActivity();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_splash;
    }

    private void jumpActivity() {

        boolean isFirst = PreferencesUtils.getBoolean(SplashActivity.this, "isFirst", true);
        //默认为第一次

        if (isFirst) {
            PreferencesUtils.putBoolean(SplashActivity.this, "isFirst", false);
//            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }

        finish();
    }
}
