package com.zc.shop.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.fragment.LoginFragment;
import com.zc.shop.fragment.RegisterFragment;
import com.zc.shop.fragment.item.AccountItemFragment;
import com.zc.shop.fragment.item.ItemFragment;
import com.zc.shop.utils.IndicatorLineUtil;
import com.zc.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAccountActivity extends BaseActivity{

    @BindView(R.id.account_viewpager)
    protected NoScrollViewPager viewpager;

    private ItemFragmentAdapter imAdapter;

    private List<Fragment> mFragments;

    private Context con;

    @BindView(R.id.account_tablayout)
    protected TabLayout tablayout;
    private String[] names = {"全部","收入","支出"};

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
        mFragments.add(new AccountItemFragment());
        mFragments.add(new AccountItemFragment());
        mFragments.add(new AccountItemFragment());


        imAdapter = new ItemFragmentAdapter(this.getSupportFragmentManager(), names, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).select();
    }

    @OnClick(R.id.account_leftButton)
    public void back(){
        this.finish();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_myaccount;
    }


}
