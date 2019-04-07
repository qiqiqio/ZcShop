package com.zc.shop.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.base.BaseFragment;
import com.zc.shop.fragment.item.OrderItemFragment;
import com.zc.shop.utils.IndicatorLineUtil;
import com.zc.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by ylwx on 2018/8/5.
 */

public class FansYJFragment extends BaseFragment {

    @BindView(R.id.order_info_viewpager)
    protected NoScrollViewPager viewpager;

    private ItemFragmentAdapter imAdapter;

    private List<Fragment> mFragments;

    private Context con;

    @BindView(R.id.order_info_tablayout)
    protected TabLayout tablayout;

    private Integer type = 1;
    private String[] names = {"今天", "本月", "上月", "所有"};

    private String[] choose;


    @Override
    protected void init() {

        choose = names;


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

        mFragments.add(new OrderItemFragment());
        mFragments.add(new OrderItemFragment());
        mFragments.add(new OrderItemFragment());
        mFragments.add(new OrderItemFragment());


        imAdapter = new ItemFragmentAdapter(this.getChildFragmentManager(), choose, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).select();

    }


    @Override
    protected int getContentResourseId() {
        return R.layout.fansyj_fragment;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {

        } else {

        }
    }
}
