package com.example.myapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Configs;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ActivitiesEntrustAdapter;
import com.example.myapplication.bean.EventBusBean;
import com.example.myapplication.bean.MyWeiTuoList;
import com.example.myapplication.net.BitzApi;
import com.example.myapplication.net.NetUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ActivitiesEntrustFragment extends Fragment {

    private RecyclerView activities_entrust_fragment_item_recy;
    private ActivitiesEntrustAdapter activitiesEntrustAdapter;
    private Context context;
    private String contractid;
    public String max_weituo_count = "5";


    public static ActivitiesEntrustFragment newInstance(String contractid) {

        Bundle args = new Bundle();
        args.putString("contractid", contractid);
        ActivitiesEntrustFragment fragment = new ActivitiesEntrustFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.activities_entrust_fragment_item, null);
        initView(inflate);


        return inflate;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        contractid = getArguments().getString("contractid");
        initNet(contractid);
    }


    public void initContractValue() {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("contractId", "101");

        new NetUtils().get(Configs.GETCONTRACTCOIN, params, new NetUtils.result() {
            @Override
            public void getResult(String result) {

            }

            @Override
            public void getFaild(String result) {

            }
        }, getActivity());
    }

    private void initNet(String contractid) {
        BitzApi bitzApi = new BitzApi("", "", "", context);
        try {
            bitzApi.getActiveOrders(contractid, new BitzApi.Result() {
                @Override
                public void getResult(String result) {

                    setData(result);
                }

                @Override
                public void getFaild(String result) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void setData(String result) {

        Gson gson = new Gson();
        MyWeiTuoList myWeiTuoList = gson.fromJson(result, MyWeiTuoList.class);

        if (myWeiTuoList.getData().size() > Double.valueOf(max_weituo_count)) {

            for (int i = 0; i < myWeiTuoList.getData().size(); i++) {

                List<MyWeiTuoList.DataBean> data = myWeiTuoList.getData();
                String orderId = data.get(i).getOrderId();
                quxiao(orderId);
            }

        }

        if (myWeiTuoList.getData().size() > 0) {
            activitiesEntrustAdapter.setNewData(myWeiTuoList.getData());
        } else {
            activitiesEntrustAdapter.setEmptyView(R.layout.emptey_weituo_item, activities_entrust_fragment_item_recy);
        }
    }

    private void quxiao(String orderId) {
        Log.i("smdhfjhsefw", "取消委托ID为：" + orderId);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("entrustSheetId", orderId);

        new NetUtils().post(Configs.CANCELCONTRACTTRADE, params, new NetUtils.result() {
            @Override
            public void getResult(String result) {
                Log.i("smdhfjhsefw", "取消委托成功");
            }

            @Override
            public void getFaild(String result) {
                Log.i("smdhfjhsefw", "取消委托失败");
            }
        }, context);
    }

    private void initView(View view) {

        activities_entrust_fragment_item_recy = (RecyclerView) view.findViewById(R.id.activities_entrust_fragment_item_recy);
        activities_entrust_fragment_item_recy.setNestedScrollingEnabled(false);

        activitiesEntrustAdapter = new ActivitiesEntrustAdapter(getActivity());
        activities_entrust_fragment_item_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        activities_entrust_fragment_item_recy.setAdapter(activitiesEntrustAdapter);
        activitiesEntrustAdapter.setEmptyView(R.layout.emptey_weituo_item, activities_entrust_fragment_item_recy);

    }

    @SuppressLint("HandlerLeak")
    private Handler handlers = new Handler() {

    };
    private Runnable runnables = new Runnable() {
        @Override
        public void run() {

            initNet(contractid);
            handlers.postDelayed(this, 5000);
        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();
        handlers.removeCallbacks(runnables);
    }

    @Override
    public void onResume() {
        super.onResume();

        handlers.postDelayed(runnables, 0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(EventBusBean message) {
        Log.i("wekufhwheu", "1");
        String id = message.id;
        contractid = id;

    }


    public void setWeituoCount(String weituoCount) {
        this.max_weituo_count = weituoCount;

    }
}
