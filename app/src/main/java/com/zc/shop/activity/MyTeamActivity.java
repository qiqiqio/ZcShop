package com.zc.shop.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.zc.shop.R;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.fragment.FansFragment;
import com.zc.shop.fragment.FansYJFragment;

import butterknife.OnClick;

public class MyTeamActivity extends BaseActivity {

    private Fragment currentFragment = new Fragment();

    private FansFragment first=new FansFragment();
    private FansYJFragment second=new FansYJFragment();

    @Override
    protected void init() {
        switchFragment(first).commit();
    }

    private FragmentTransaction switchFragment(Fragment targetFragment) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fragment_content, targetFragment,targetFragment.getClass().getName());

        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return   transaction;
    }


    @OnClick(R.id.account_leftButton)
    public void back() {
        this.finish();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_myteam;
    }

    @OnClick(R.id.team_fans)
    public void changeFan() {
        switchFragment(first).commit();

    }

    @OnClick(R.id.team_fans_yj)
    public void changeFanYJ() {
        switchFragment(second).commit();

    }

}
