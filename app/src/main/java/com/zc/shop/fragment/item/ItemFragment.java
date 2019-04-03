package com.zc.shop.fragment.item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.zc.shop.R;
import com.zc.shop.base.BaseFragment;

import butterknife.BindView;


/**
 * Created by ylwx on 2018/8/5.
 */

public class ItemFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_view)
    MaterialRefreshLayout mRefreshLaout;

    private String categoryKey;

    @Override
    protected void init() {

    }

    @Override
    protected int getContentResourseId() {
        return R.layout.item_fragment;
    }
}
