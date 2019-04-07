package com.zc.shop.activity;

import com.zc.shop.R;
import com.zc.shop.base.BaseActivity;

import butterknife.OnClick;

public class MyTeamActivity extends BaseActivity{


    @Override
    protected void init() {

    }

    @OnClick(R.id.account_leftButton)
    public void back(){
        this.finish();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_myteam;
    }


}
