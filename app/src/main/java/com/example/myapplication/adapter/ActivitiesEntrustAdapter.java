package com.example.myapplication.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.MyWeiTuoList;

public class ActivitiesEntrustAdapter extends BaseQuickAdapter<MyWeiTuoList.DataBean, BaseViewHolder> {

    public ActivitiesEntrustAdapter(Context context) {
        super(R.layout.activities_entrust_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyWeiTuoList.DataBean item) {

        String direction = item.getDirection();
        String isCross = item.getIsCross();
        String leverage = item.getLeverage();
        String pair = item.getPair();
        String type = item.getType();
        String price = item.getPrice();
        String available = item.getAvailable();

        if ("limit".equals(type)) {
            type = "限价";
        } else {
            type = "市价";
        }

        if ("1".equals(isCross)) {
            isCross = "全仓";
        } else {
            isCross = "逐仓";
        }

        if ("1".equals(direction)) {
            direction = "做多";
        } else {
            direction = "做空";
        }

        helper.setText(R.id.weituo_leixin_title, pair + " " + direction + " " + "(" + isCross + " " + leverage + "X" + ")");
        helper.setText(R.id.weituo_leixin, type);
        helper.setText(R.id.weituo_price, price);
        helper.setText(R.id.weituo_leixin_shengyu_shuliang, available);


    }
}
