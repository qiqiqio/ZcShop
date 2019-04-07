package com.zc.shop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;
import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.adapter.MyAccountAdapter;
import com.zc.shop.base.BaseFragment;
import com.zc.shop.bean.Goods;
import com.zc.shop.fragment.item.AccountItemFragment;
import com.zc.shop.fragment.item.OrderItemFragment;
import com.zc.shop.utils.IndicatorLineUtil;
import com.zc.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by ylwx on 2018/8/5.
 */

public class OrderFragment extends BaseFragment {

    @BindView(R.id.order_info_viewpager)
    protected NoScrollViewPager viewpager;

    private ItemFragmentAdapter imAdapter;

    private List<Fragment> mFragments;

    private Context con;

    @BindView(R.id.order_info_tablayout)
    protected TabLayout tablayout;

    private Integer type = 1;
    private String[] names = {"全部", "待发货", "待收货", "已完成"};

    private String[] names2 = {"全部", "挂售成功", "已完成"};

    private String[] choose;


    @Override
    protected void init() {
        Bundle bundle = getArguments();
        if(null!=bundle){
            String typeArg = bundle.getString("type");

            if (null == typeArg || typeArg.trim().length()==0) {
                type = 1;
                choose = names;
            } else {
                type = Integer.parseInt(typeArg);
                choose = names2;

            }

        }else{
            type = 1;
            choose = names;
        }

        viewpager.setScroll(false);

        tablayout.setTabTextColors(ContextCompat.getColor(this.getActivity(), R.color.black), ContextCompat.getColor(this.getActivity(), R.color.red));
        tablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this.getActivity(), R.color.red));

        tablayout.post(new Runnable() {
            @Override
            public void run() {
                IndicatorLineUtil.setIndicator(tablayout, 10, 10);
            }
        });
        mFragments = new ArrayList<>();

        if (type == 1 ) {
            mFragments.add(new OrderItemFragment());
            mFragments.add(new OrderItemFragment());
            mFragments.add(new OrderItemFragment());
            mFragments.add(new OrderItemFragment());

        } else {
            mFragments.add(new OrderItemFragment());
            mFragments.add(new OrderItemFragment());
            mFragments.add(new OrderItemFragment());
        }


        imAdapter = new ItemFragmentAdapter(this.getChildFragmentManager(), choose, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).select();

    }


    @Override
    protected int getContentResourseId() {
        return R.layout.order_fragment;
    }


}
