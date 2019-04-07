package com.zc.shop.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.design.widget.TabLayout;

import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.fragment.OrderFragment;
import com.zc.shop.fragment.item.AccountItemFragment;
import com.zc.shop.utils.IndicatorLineUtil;
import com.zc.shop.widget.MyTabLayout;
import com.zc.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyOrderActivity extends BaseActivity{

    @BindView(R.id.order_viewpager)
    protected NoScrollViewPager viewpager;

    private ItemFragmentAdapter imAdapter;

    private List<Fragment> mFragments;

    private Context con;

    @BindView(R.id.order_tablayout)
    protected TabLayout tablayout;
    private String[] names = {"积分订单","零售订单","批发订单"};

    @Override
    protected void init() {

//        List<String> titles = Arrays.asList(names);
//        tablayout.setTitle(titles);


        tablayout.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.red));
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.red));

        tablayout.post(new Runnable() {
            @Override
            public void run() {
                IndicatorLineUtil.setIndicator(tablayout, 20, 20);
            }
        });

        mFragments = new ArrayList<>();
        mFragments.add(new OrderFragment());
        mFragments.add(new OrderFragment());

        OrderFragment third=new OrderFragment();
        Bundle b=new Bundle();
        b.putString("type","2");
        third.setArguments(b);
        mFragments.add(third);
//
        imAdapter = new ItemFragmentAdapter(this.getSupportFragmentManager(), names, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).select();
    }

    @OnClick(R.id.order_leftButton)
    public void back(){
        this.finish();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_myorder;
    }


}
