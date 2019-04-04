package com.zc.shop.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.fragment.LoginFragment;
import com.zc.shop.fragment.RegisterFragment;
import com.zc.shop.utils.IndicatorLineUtil;
import com.zc.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_viewpager)
    protected NoScrollViewPager viewpager;

    private ItemFragmentAdapter imAdapter;

    private List<Fragment> mFragments;

    private Context con;

    @BindView(R.id.login_tablayout)
    protected TabLayout tablayout;
    private String[] names = {"注册","登录"};

    @Override
    protected void init() {

        viewpager.setScroll(false);

        tablayout.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red));
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red));

        tablayout.post(new Runnable() {
            @Override
            public void run() {
                IndicatorLineUtil.setIndicator(tablayout, 40, 40);
            }
        });

        mFragments = new ArrayList<>();
        mFragments.add(new RegisterFragment());
        mFragments.add(new LoginFragment());


        imAdapter = new ItemFragmentAdapter(this.getSupportFragmentManager(), names, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(1).select();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_login;
    }
}
