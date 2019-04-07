package com.zc.shop.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.zc.shop.R;
import com.zc.shop.adapter.ItemFragmentAdapter;
import com.zc.shop.base.BaseFragment;
import com.zc.shop.fragment.item.ItemFragment;
import com.zc.shop.utils.IndicatorLineUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HotFragment extends BaseFragment {


    private List<Fragment> mFragments;
    private ItemFragmentAdapter imAdapter;

    @BindView(R.id.my_viewpager)
    protected ViewPager viewpager;
    private Context con;

    @BindView(R.id.my_tablayout)
    protected TabLayout tablayout2;
    private String[] names = {"热门商品","数码产品","时尚配饰", "日用百货", "食品保健", "其他商品"};
    @Override
    protected void init() {
//        StatusBarUtil.setRootViewFitsSystemWindows(this.getTargetFragment().getActivity(), false);
        tablayout2.setTabMode(TabLayout.MODE_SCROLLABLE);
//        tablayout2.setTabTextColors(ContextCompat.getColor(this.getContext(), R.color.gray), ContextCompat.getColor(this.getActivity(), R.color.white));
        tablayout2.setTabTextColors(ContextCompat.getColor(this.getContext(), R.color.black), ContextCompat.getColor(this.getContext(), R.color.red));
        tablayout2.setSelectedTabIndicatorColor(ContextCompat.getColor(this.getContext(), R.color.red));

        tablayout2.post(new Runnable() {
            @Override
            public void run() {
                IndicatorLineUtil.setIndicator(tablayout2, 10, 10);
            }
        });

        mFragments = new ArrayList<>();
        mFragments.add(new ItemFragment());
        mFragments.add(new ItemFragment());
        mFragments.add(new ItemFragment());

        mFragments.add(new ItemFragment());

        mFragments.add(new ItemFragment());

        mFragments.add(new ItemFragment());

        imAdapter = new ItemFragmentAdapter(getChildFragmentManager(), names, mFragments, con);
        viewpager.setAdapter(imAdapter);
        tablayout2.setupWithViewPager(viewpager);
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.hot_fragment;
    }

}
