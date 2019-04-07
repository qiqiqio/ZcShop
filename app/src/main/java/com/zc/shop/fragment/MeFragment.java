package com.zc.shop.fragment;

import android.content.Intent;

import com.zc.shop.R;
import com.zc.shop.activity.MyAccountActivity;
import com.zc.shop.activity.MyInfoActivity;
import com.zc.shop.activity.MyLocationActivity;
import com.zc.shop.activity.MyOrderActivity;
import com.zc.shop.activity.MyTeamActivity;
import com.zc.shop.base.BaseFragment;

import butterknife.OnClick;

public class MeFragment extends BaseFragment {
    @Override
    protected void init() {

    }

    @OnClick(R.id.me_account)
    public void goMyAccount(){
        Intent loginIntent = new Intent(this.getActivity(), MyAccountActivity.class);
        super.startActivity(loginIntent);
    }

    @OnClick(R.id.my_order)
    public void goMyOrder(){
        Intent loginIntent = new Intent(this.getActivity(), MyOrderActivity.class);
        super.startActivity(loginIntent);
    }

    @OnClick(R.id.my_team)
    public void goMyTeam(){
        Intent loginIntent = new Intent(this.getActivity(), MyTeamActivity.class);
        super.startActivity(loginIntent);
    }

    @OnClick(R.id.my_info)
    public void goMyInfo(){
        Intent loginIntent = new Intent(this.getActivity(), MyInfoActivity.class);
        super.startActivity(loginIntent);
    }

    @OnClick(R.id.my_location)
    public void goMyLocation(){
        Intent loginIntent = new Intent(this.getActivity(), MyLocationActivity.class);
        super.startActivity(loginIntent);
    }


    @Override
    protected int getContentResourseId() {
        return R.layout.me_fragment;
    }
}
