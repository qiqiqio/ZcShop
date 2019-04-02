package com.zc.shop;

import android.content.Context;
import android.content.Intent;

import com.zc.shop.base.BaseApplication;
import com.zc.shop.bean.User;
import com.zc.shop.utils.UserLocalData;

public class ZcApplication extends BaseApplication {

    private static ZcApplication instance;

    private User user;

    public static Context sContext;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initUser();

        init();
    }


    //初始化
    private void init() {
        //初始化http
    }

    private void initUser() {
        this.user = UserLocalData.getUser(this);
    }

    public User getUser() {
        return user;
    }

    public void putUser(User user, String token) {
        this.user = user;
        UserLocalData.putUser(this, user);
        UserLocalData.putToken(this, token);
    }

    public void clearUser() {
        this.user = null;
        UserLocalData.clearUser(this);
        UserLocalData.clearToken(this);
    }


    public String getToken() {
        return UserLocalData.getToken(this);
    }

    private Intent intent;

    public void putIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }
    /**
     * 获得当前app运行的AppContext
     *
     * @return AppContext
     */
    public static ZcApplication getInstance() {
        return instance;
    }

}
