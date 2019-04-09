package com.zc.shop.activity;

import com.zc.shop.R;
import com.zc.shop.base.BaseActivity;

import butterknife.OnClick;

public class HomeNoticeActivity extends BaseActivity {
    @Override
    protected void init() {

    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_homenotice;
    }

    @OnClick(R.id.notice_close)
    public void closeNotice(){
        finish();
    }
}
