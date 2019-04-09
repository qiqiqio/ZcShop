package com.zc.shop.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zc.shop.R;
import com.zc.shop.base.BaseActivity;
import com.zc.shop.bean.MessageEvent;
import com.zc.shop.bean.Tab;
import com.zc.shop.fragment.FindFragment;
import com.zc.shop.fragment.HotFragment;
import com.zc.shop.fragment.MeFragment;
import com.zc.shop.utils.ToastUtils;
import com.zc.shop.widget.FragmentTabHost;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void init() {
        initTab();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_main;
    }

    private void initTab() {
        Tab tab_hot = new Tab(HotFragment.class, R.string.tabs_hot, R.drawable.selector_icon_home);
        Tab find_hot = new Tab(FindFragment.class, R.string.tabs_find, R.drawable.selector_icon_hot);
        Tab me_hot = new Tab(MeFragment.class, R.string.tabs_me, R.drawable.selector_icon_mine);

        mTabs.add(tab_hot);
        mTabs.add(find_hot);
        mTabs.add(me_hot);

        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec, tab.getFragment(), null);
        }


        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);           //默认选中第0个
    }

    private View buildIndicator(Tab tab) {

        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setImageResource(tab.getIcon());
        text.setText(tab.getTitle());

        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.getType() == 0) {
            mTabhost.setCurrentTab(1);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    //控制物理返回键
    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showSafeToast(MainActivity.this, "再点一次退出ZCShop");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
