package com.example.myapplication.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.CoinBean;

public class ContractCoinAdapter extends BaseQuickAdapter<CoinBean, BaseViewHolder> {

    public ContractCoinAdapter() {
        super(R.layout.contractcoin_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, CoinBean item) {

        helper.setText(R.id.contractcoin_item_tv_name, item.getPair());
        helper.setText(R.id.contractcoin_item_tv_gangan, item.getAllowLeverages() + "(可用杠杆)");

    }
}
