package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.MyPositionBean;
import com.example.myapplication.utils.Conutil;

public class MyPositionAdapter extends BaseQuickAdapter<MyPositionBean.DataBean, BaseViewHolder> {

    private Context context;

    public MyPositionAdapter(Context context) {
        super(R.layout.my_position_adapter_item);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPositionBean.DataBean item) {

        int endTime = item.getEndTime();


        Log.i("wekjhkweuhfwie", endTime+"");
        String s1 = Conutil.timedate(endTime + "");


        helper.setText(R.id.my_position_adapter_tv_yi_yinkui, item.getRlzPnl());
        helper.setText(R.id.my_position_adapter_tv_time, s1);
    }
}
