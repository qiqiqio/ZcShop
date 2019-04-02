package com.zc.shop.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.zc.shop.bean.User;


/**
 * Created by 高磊华
 * Time  2017/8/11
 * Describe: 用户的个人信息需要保存在本地
 */

public class UserLocalData {

    private static Gson mGson = new Gson();

    public static String USER_JSON = "user_json";
    public static final String TOKEN = "token";

    public static void putUser(Context context, User user) {
        String user_json = mGson.toJson(user);
        PreferencesUtils.putString(context, USER_JSON, user_json);
    }

    public static void putToken(Context context, String token) {
        PreferencesUtils.putString(context, TOKEN, token);
    }


    public static User getUser(Context context) {

        String user_json = PreferencesUtils.getString(context, USER_JSON);
        if (!TextUtils.isEmpty(user_json)) {
            return mGson.fromJson(user_json, User.class);
        }
        return null;
    }

    public static String getToken(Context context) {
        return PreferencesUtils.getString(context, TOKEN);
    }


    public static void clearUser(Context context) {
        PreferencesUtils.putString(context, USER_JSON, "");
    }

    public static void clearToken(Context context) {
        PreferencesUtils.putString(context, TOKEN, "");
    }

}
