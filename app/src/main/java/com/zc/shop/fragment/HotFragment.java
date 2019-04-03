package com.zc.shop.fragment;

import com.zc.shop.R;
import com.zc.shop.base.BaseFragment;
import com.zc.shop.utils.StatusBarUtil;

public class HotFragment extends BaseFragment {
    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this.getTargetFragment().getActivity(), false);
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.hot_fragment;
    }
}
