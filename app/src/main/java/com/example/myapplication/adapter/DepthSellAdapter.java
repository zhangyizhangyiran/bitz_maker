package com.example.myapplication.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.DepthList;

public class DepthSellAdapter extends BaseQuickAdapter<DepthList.DataBean.AsksBean, BaseViewHolder> {
    private int type = 0;
    private Context context;

    public DepthSellAdapter(Context context) {
        super(R.layout.depth_buy_item);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DepthList.DataBean.AsksBean item) {

        helper.setText(R.id.depth_item_tv_price, item.getPrice());
        helper.setText(R.id.depth_item_tv_amount, item.getAmount());
        helper.setTextColor(R.id.depth_item_tv_price, context.getResources().getColor(R.color.treaty_bg_but_sell));
        helper.setTextColor(R.id.depth_item_tv_amount, context.getResources().getColor(R.color.treaty_bg_but_sell));


    }

}
