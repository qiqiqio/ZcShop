package com.zc.shop.fragment.item;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;
import com.zc.shop.R;
import com.zc.shop.adapter.RecyclerAdapter;
import com.zc.shop.base.BaseFragment;
import com.zc.shop.bean.Goods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by ylwx on 2018/8/5.
 */

public class ItemFragment extends BaseFragment implements RecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_view)
    MaterialRefreshLayout mRefreshLaout;

    private String categoryKey;

    @Override
    protected void init() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        //设置布局管理器
        mRecyclerView.setLayoutManager(gridLayoutManager);

        //设置为垂直布局，这也是默认的
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);

        RecyclerAdapter adapter = new RecyclerAdapter(this.getContext(), getData());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);//将接口传递到数据产生的地方

    }

    private List<Goods> getData() {
        ArrayList<Goods> list =new ArrayList<Goods>();
        Goods goods1=new Goods();
        goods1.setName("商品1");

        Goods goods2=new Goods();
        goods1.setName("商品12");

        Goods goods3=new Goods();
        goods1.setName("商品13");

        Goods goods4=new Goods();
        goods1.setName("商品14");

        list.add(goods1);
        list.add(goods2);
        list.add(goods3);
        list.add(goods4);

        return list;

    }

    @Override
    protected int getContentResourseId() {
        return R.layout.item_fragment;
    }

    @Override
    public void onItemClick(int position, Goods model) {

    }
}
