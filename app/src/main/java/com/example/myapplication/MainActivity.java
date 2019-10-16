package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.adapter.ContractCoinAdapter;
import com.example.myapplication.adapter.DepthBuyAdapter;
import com.example.myapplication.adapter.DepthSellAdapter;
import com.example.myapplication.bean.AccountInfoBean;
import com.example.myapplication.bean.CoinBean;
import com.example.myapplication.bean.ContractCoinBean;
import com.example.myapplication.bean.ContractDetailsBean;
import com.example.myapplication.bean.DepthList;
import com.example.myapplication.bean.EventBusBean;
import com.example.myapplication.bean.MyActivePOsitionsBean;
import com.example.myapplication.bean.MyPositionBean;
import com.example.myapplication.bean.MyWeiTuoList;
import com.example.myapplication.bean.TickersBean;
import com.example.myapplication.fragment.ActivitiesEntrustFragment;
import com.example.myapplication.net.BitzApi;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView treaty_recy_buy;
    private RecyclerView treaty_recy_sell;
    private RecyclerView bit_recy_drawer;
    private DepthSellAdapter depthSellAdapter;
    private DepthBuyAdapter depthBuyAdapter;
    private BitzApi bitzApi;
    private ContractCoinAdapter contractCoinAdapter;
    private TextView activity_mian_tv_ce_l;
    private TextView activity_mian_tv_end;
    private TextView activity_mian_tv_open;
    private TextView treaty_tv_index_price;
    private TextView treaty_tv_heli_price;
    private TextView treaty_tv_new_index;
    private TextView main_tv_balance;
    private ImageView app_bar_setting;
    private TextView main_yi_pingcang;
    private MaterialButton activity_mian_tv_gong_si;
    public String contractid = "101";
    private DrawerLayout drawer_layout;
    private TextView position_item_tv_title;
    private TextView position_item_tv_open_price;
    private TextView position_item_tv_liquidationPrice;
    private TextView position_item_tv_unrlzPnl;
    private TextView position_item_tv_rlzPnl;
    private TextView main_tv_amount;
    private TextView main_tv_feilv;
    private TextView main_tv_yi_yinkui;
    private TextView app_bar_title;
    private TextView xiandan_zhangshu;
    private TextView xiandan_sudu;
    private TextView xiandan_wei_tuo;
    private TextView xiandan_ganggan;

    private String nextFundingRate;
    private String count;
    private String times;
    private String max_count;
    private String ganggan;
    private FrameLayout treaty_framelayout;
    private View treaty_lin_positon;
    private View treaty_lin_emptey;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitzApi = new BitzApi("", "", "", MainActivity.this);

        initView();
        initAdapter();
        initNet(contractid, false);
        initDrawerLayout();
        getMxDataTickers();
        getContractDetails();
        initOncilk();
    }


    private void getContractDetails() {
        try {
            bitzApi.getMxDataAontracts(contractid, new BitzApi.Result() {
                @Override
                public void getResult(String result) {

                    Gson gson = new Gson();
                    ContractDetailsBean contractDetailsBean = gson.fromJson(result, ContractDetailsBean.class);
                    String settleAnchor = contractDetailsBean.getData().get(0).getSettleAnchor();
                    getInfo(settleAnchor);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void getInfo(final String settleAnchor) {
        try {
            bitzApi.getAccountInfo(new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    Log.i("wqwlwkqklw", result);
                    setAccountInfo(result, settleAnchor);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAccountInfo(String s, String result) {

        Gson gson = new Gson();
        AccountInfoBean accountInfoBean = gson.fromJson(s, AccountInfoBean.class);

        for (int i = 0; i < accountInfoBean.getData().getBalances().size(); i++) {
            String coin = accountInfoBean.getData().getBalances().get(i).getCoin();
            if (result.equals(coin)) {
                Log.i("12121qe", "1");
                String balance = accountInfoBean.getData().getBalances().get(i).getBalance();
                main_tv_balance.setText(balance + " " + result);
            }
        }

    }

    //获取合约详情
    private void getMxDataTickers() {
        try {
            bitzApi.getMxDataTickers(contractid, new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    setMxDataTickers(result);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void setMxDataTickers(String result) {
        Gson gson = new Gson();
        TickersBean tickersBean = gson.fromJson(result, TickersBean.class);
        List<TickersBean.DataBean> data = tickersBean.getData();
        TickersBean.DataBean dataBean = data.get(0);
        String latest = dataBean.getLatest();
        String indexPrice = dataBean.getIndexPrice();
        String fairPrice = dataBean.getFairPrice();


        //预测资金率
        nextFundingRate = dataBean.getNextFundingRate();
        Double aDouble = Double.valueOf(nextFundingRate);
        double nextFundingRates = aDouble * 100;
        String format = String.format("%.4f", nextFundingRates);
        main_tv_feilv.setText(format + "%");
        treaty_tv_index_price.setText(latest);
        treaty_tv_heli_price.setText("指数价格:" + "  " + indexPrice);
        treaty_tv_new_index.setText("公平价格:" + "  " + fairPrice);

    }

    private void initOncilk() {

        //开始跑
        activity_mian_tv_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(times)) {
                    Toast.makeText(MainActivity.this, "请先配置策略", Toast.LENGTH_SHORT).show();

                } else {
                    handlers.removeCallbacks(runnables);
                    handlers.postDelayed(runnables, 0);
                }
            }
        });

        //结束跑
        activity_mian_tv_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlers.removeCallbacks(runnables);

            }
        });


        main_yi_pingcang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MyPositionActivity.class));
            }
        });

        app_bar_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(Gravity.LEFT);
            }
        });

        activity_mian_tv_gong_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, SettingActivity.class), 911);
            }
        });

        activity_mian_tv_ce_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, StrategyActivity.class), 911);
            }
        });
    }


    private void initView() {
        treaty_lin_positon = findViewById(R.id.treaty_lin_positon);
        treaty_lin_emptey = findViewById(R.id.treaty_lin_emptey);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        treaty_recy_buy = (RecyclerView) findViewById(R.id.treaty_recy_buy);
        treaty_recy_sell = (RecyclerView) findViewById(R.id.treaty_recy_sell);
        bit_recy_drawer = (RecyclerView) findViewById(R.id.bit_recy_drawer);
        activity_mian_tv_ce_l = (TextView) findViewById(R.id.activity_mian_tv_ce_l);
        activity_mian_tv_open = (TextView) findViewById(R.id.activity_mian_tv_open);
        activity_mian_tv_end = (TextView) findViewById(R.id.activity_mian_tv_end);
        treaty_tv_index_price = (TextView) findViewById(R.id.treaty_tv_index_price);
        treaty_tv_new_index = (TextView) findViewById(R.id.treaty_tv_new_index);
        treaty_tv_heli_price = (TextView) findViewById(R.id.treaty_tv_heli_price);
        main_tv_balance = (TextView) findViewById(R.id.main_tv_balance);
        app_bar_setting = (ImageView) findViewById(R.id.app_bar_setting);
        main_yi_pingcang = (TextView) findViewById(R.id.main_yi_pingcang);
        activity_mian_tv_gong_si = (MaterialButton) findViewById(R.id.activity_mian_tv_gong_si);


        position_item_tv_title = (TextView) findViewById(R.id.position_item_tv_title);
        position_item_tv_open_price = (TextView) findViewById(R.id.position_item_tv_open_price);
        position_item_tv_liquidationPrice = (TextView) findViewById(R.id.position_item_tv_liquidationPrice);
        position_item_tv_unrlzPnl = (TextView) findViewById(R.id.position_item_tv_unrlzPnl);
        position_item_tv_rlzPnl = (TextView) findViewById(R.id.position_item_tv_rlzPnl);
        main_tv_amount = (TextView) findViewById(R.id.main_tv_amount);
        main_tv_feilv = (TextView) findViewById(R.id.main_tv_feilv);
        main_tv_yi_yinkui = (TextView) findViewById(R.id.main_tv_yi_yinkui);
        app_bar_title = (TextView) findViewById(R.id.app_bar_title);
        xiandan_zhangshu = (TextView) findViewById(R.id.xiandan_zhangshu);
        xiandan_sudu = (TextView) findViewById(R.id.xiandan_sudu);
        xiandan_wei_tuo = (TextView) findViewById(R.id.xiandan_wei_tuo);
        xiandan_ganggan = (TextView) findViewById(R.id.xiandan_ganggan);


        treaty_framelayout = (FrameLayout) findViewById(R.id.treaty_framelayout);

        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.treaty_framelayout, ActivitiesEntrustFragment.newInstance(contractid), "one");
        fragmentTransaction.addToBackStack("one");
        fragmentTransaction.commit();


    }

    private void initAdapter() {
        depthSellAdapter = new DepthSellAdapter(this);
        depthBuyAdapter = new DepthBuyAdapter(this);
        contractCoinAdapter = new ContractCoinAdapter();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);//列表再底部开始展示，反转后由上面开始展示
        linearLayoutManager.setReverseLayout(true);//列表翻转


        treaty_recy_sell.setLayoutManager(linearLayoutManager);
        treaty_recy_buy.setLayoutManager(new LinearLayoutManager(this));
        treaty_recy_sell.setAdapter(depthSellAdapter);
        treaty_recy_buy.setAdapter(depthBuyAdapter);
        bit_recy_drawer.setLayoutManager(new LinearLayoutManager(this));
        bit_recy_drawer.setAdapter(contractCoinAdapter);

    }

    private void initNet(String contractID, final boolean ispos) {


        try {
            bitzApi.getMxDataOrderBook(contractID, new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    setData(result, ispos);
                }

                @Override
                public void getFaild(String result) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDrawerLayout() {
        try {
            bitzApi.getMxDataAontracts("", new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    setDrawerLayoutData(result);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    private void setDrawerLayoutData(String result) {
        Gson gson = new Gson();
        ContractCoinBean contractCoinBean = gson.fromJson(result, ContractCoinBean.class);
        contractCoinAdapter.setNewData(contractCoinBean.getData());

        contractCoinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                drawer_layout.closeDrawers();
                Log.i("wejfkwjefniwuef", "1");

                List data = adapter.getData();
                CoinBean coinBean = (CoinBean) data.get(position);
                String contractId = coinBean.getContractId();

                app_bar_title.setText(coinBean.getPair());

                EventBusBean eventBusBean = new EventBusBean();
                eventBusBean.id = contractId;

                EventBus.getDefault().post(eventBusBean);


                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
                if (handlers != null) {
                    handlers.removeCallbacks(runnables);
                }

                contractid = contractId;

                if (handler != null) {
                    handler.postDelayed(runnable, 0);
                }

            }
        });

    }

    private void setData(String result, boolean ispos) {
        String bidsprice = "";
        String asksprice = "";
        Gson gson = new Gson();
        DepthList depthList = gson.fromJson(result, DepthList.class);
        DepthList.DataBean data = depthList.getData();
        List<DepthList.DataBean.AsksBean> asks = data.getAsks();
        List<DepthList.DataBean.BidsBean> bids = data.getBids();
        depthSellAdapter.setNewData(asks);
        depthBuyAdapter.setNewData(bids);
        if (bids.size() > 0) {
            bidsprice = bids.get(0).getPrice();
        }

        if (asks.size() > 0) {
            asksprice = asks.get(0).getPrice();
        }


        if (ispos) {
            if (!TextUtils.isEmpty(bidsprice) || !TextUtils.isEmpty(asksprice)) {
                Double doublebidsprice = Double.valueOf(bidsprice);
                Double doubleasksprice = Double.valueOf(asksprice);
                double new_doublebidsprice = doublebidsprice;
                double new_doubleasksprice = doubleasksprice;
                Log.i("smdhfjhsefw", "开始询盘口" + "=====" + new_doublebidsprice + "======" + new_doubleasksprice);

                getMyActivePosition(new_doublebidsprice, new_doubleasksprice);
//                getWeiTuoList(new_doublebidsprice, new_doubleasksprice);
            }
        }
    }

    private void xiaDan(double new_price, String fangxiang) {
        Log.i("smdhfjhsefw", "开始下单");
        Log.i("smdhfjhsefw", new_price + "======" + count + "=======" + ganggan + "=====" + fangxiang);

        try {
            bitzApi.getPlaceOrder(contractid, new_price + "", count, ganggan, fangxiang, "limit", "-1", new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    Log.i("smdhfjhsefw", "下单成功");
                    callAll();

                }

                @Override
                public void getFaild(String result) {
                    Log.i("smdhfjhsefw", "下单失败");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void callAll() {
        callOkgo();
//        handlers.removeCallbacks(runnables);
//        handlers.postDelayed(runnables, 0);
    }


    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

    };
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            initNet(contractid, false);
            getContractDetails();
            getMxDataTickers();
            //以平仓仓位
            getMyPosition();
            handler.postDelayed(this, 6000);
        }
    };


    @SuppressLint("HandlerLeak")
    private Handler handlers = new Handler() {

    };
    private Runnable runnables = new Runnable() {
        @Override
        public void run() {
            initNet(contractid, true);
            if (TextUtils.isEmpty(times)) {

                Toast.makeText(MainActivity.this, "请先配置策略", Toast.LENGTH_SHORT).show();
            } else {
                handlers.postDelayed(this, Long.valueOf(times));
            }

        }
    };


    //获取我的仓位
    private void getMyActivePosition(final double new_doublebidsprice, final double new_doubleasksprice) {
        Log.i("smdhfjhsefw", "获取仓位");
        try {
            bitzApi.getMyActivePositions(contractid, new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    Log.i("test1111", result);
                    setMyActivePositionInfo(result, new_doublebidsprice, new_doubleasksprice);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void getMyPosition() {
        try {
            bitzApi.getMyPositions(contractid, "1", "500", new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    double totalVal = 0;
                    Gson gson = new Gson();
                    MyPositionBean myPositionBean = gson.fromJson(result, MyPositionBean.class);
                    List<MyPositionBean.DataBean> data = myPositionBean.getData();
                    for (int i = 0; i < data.size(); i++) {
                        String rlzPnl = data.get(i).getRlzPnl();

                        Double aDouble = Double.valueOf(rlzPnl);
                        totalVal = totalVal + aDouble;
                    }

                    main_tv_yi_yinkui.setText(totalVal + "");
                    Log.i("ewheufhwueif", totalVal + "");

                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void setMyActivePositionInfo(String result, double new_doublebidsprice, double new_doubleasksprice) {

        String fangxiang = "";
        double prices;
        Gson gson = new Gson();
        MyActivePOsitionsBean myActivePOsitionsBean = gson.fromJson(result, MyActivePOsitionsBean.class);
        int size = myActivePOsitionsBean.getData().size();
        if (size > 0) {
            treaty_lin_positon.setVisibility(View.VISIBLE);
            treaty_lin_emptey.setVisibility(View.GONE);
            Log.i("smdhfjhsefw", "有仓位");
            MyActivePOsitionsBean.DataBean dataBean = myActivePOsitionsBean.getData().get(0);
            String amount = dataBean.getAmount();

            String direction = dataBean.getDirection();
            String pair = dataBean.getPair();
            //开仓价
            String price = dataBean.getPrice();
            //未实现
            String unrlzPnl = dataBean.getUnrlzPnl();
            //已实现
            String rlzPnl = dataBean.getRlzPnl();
            String leverage = dataBean.getLeverage();
            //强平价格
            String liquidationPrice = dataBean.getLiquidationPrice();

            String isCross = dataBean.getIsCross();


            if (isCross.equals("1")) {
                //全仓
                isCross = "全仓";

            } else {
                //逐仓
                isCross = "逐仓";
            }

            if (direction.equals("1")) {
                direction = "多";
            } else {
                direction = "空";
            }

            main_tv_amount.setText(amount + "张");
            position_item_tv_open_price.setText(price);
            position_item_tv_liquidationPrice.setText(liquidationPrice);
            position_item_tv_unrlzPnl.setText(unrlzPnl);
            position_item_tv_rlzPnl.setText(rlzPnl);
            position_item_tv_title.setText(pair + " " + direction + " " + "(" + isCross + " " + leverage + "X" + ")");

            if ("多".equals(direction)) {
                fangxiang = "-1";
//                prices = new_doublebidsprice;
                prices = new_doubleasksprice;
            } else {
                fangxiang = "1";
//                prices = new_doubleasksprice;
                prices = new_doublebidsprice;
            }

            validation(contractid, prices + "", fangxiang);


        } else {
            main_tv_amount.setText("0" + "张");
            treaty_lin_positon.setVisibility(View.GONE);
            treaty_lin_emptey.setVisibility(View.VISIBLE);
//            xiaDan(new_doubleasksprice, "-1");
            validation(contractid, new_doubleasksprice + "", "-1");
            Log.i("smdhfjhsefw", "无仓位开始挂maker单" + "====" + new_doublebidsprice);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (handler != null) {
            handler.postDelayed(runnable, 0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 200) {
            Bundle extras = data.getExtras();
            Object result = extras.get("result");
            String s = result.toString();
            try {
                JSONObject jsonObject = new JSONObject(s);
                //合约张数
                count = jsonObject.getString("count");
                //间隔时间
                times = jsonObject.getString("times");
                max_count = jsonObject.getString("max_count");
                ganggan = jsonObject.getString("ganggan");


                xiandan_zhangshu.setText(count + "张");
                xiandan_sudu.setText(times);
                xiandan_wei_tuo.setText(max_count);
                xiandan_ganggan.setText(ganggan);

                setFragmentVal(max_count);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFragmentVal(String max_count) {
        Fragment fragment = supportFragmentManager.findFragmentByTag("one");

        if (fragment != null) {
            Log.i("kwjefkwueifh", "1");
            ActivitiesEntrustFragment activitiesEntrustFragment = (ActivitiesEntrustFragment) fragment;
            activitiesEntrustFragment.setWeituoCount(max_count);
        } else {
            Log.i("kwjefkwueifh", "2");
        }
    }

    public void callOkgo() {
        OkGo.getInstance().cancelAll();

    }

    private void validation(String contractid, final String price, final String fangxiang) {


        try {
            bitzApi.getActiveOrders(contractid, new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    setData(result, price, fangxiang);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void setData(String result, String price, String fangxiang) {


        Log.i("smdhfjhsefw", "开始验证");
        Gson gson = new Gson();
        MyWeiTuoList myWeiTuoList = gson.fromJson(result, MyWeiTuoList.class);

        if (myWeiTuoList.getData().size() > 0) {
            for (int i = 0; i < myWeiTuoList.getData().size(); i++) {

                List<MyWeiTuoList.DataBean> data = myWeiTuoList.getData();
                String oldprice = data.get(i).getPrice();
                if (!price.equals(oldprice)) {
                    Log.i("smdhfjhsefw", "价格不同" + "oldprice===" + oldprice + "price===" + price);
                    xiaDan(Double.valueOf(price), fangxiang);
                } else {
                    Log.i("smdhfjhsefw", "价格相同不下单" + "oldprice===" + oldprice + "price===" + price);
                }

            }
        } else {
            xiaDan(Double.valueOf(price), fangxiang);
        }


    }


}
