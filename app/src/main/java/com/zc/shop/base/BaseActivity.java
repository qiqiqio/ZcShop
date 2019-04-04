package com.zc.shop.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zc.shop.ZcApplication;
import com.zc.shop.activity.LoginActivity;
import com.zc.shop.bean.User;

import butterknife.ButterKnife;

/**
 * Created by 高磊华
 * Time  2017/8/9
 * Describe:activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourseId());
        ButterKnife.bind(this);
        init();
    }


    protected abstract void init();

    protected abstract int getContentResourseId();

    public void startActivity(Intent intent, boolean isNeedLogin) {

        if (isNeedLogin) {
            User user = ZcApplication.getInstance().getUser();
            if (user != null) {
                super.startActivity(intent);
            } else {
                ZcApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(this, LoginActivity.class);
                super.startActivity(intent);
            }

        } else {
            super.startActivity(intent);
        }
    }

}
