package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.MyPositionAdapter;
import com.example.myapplication.bean.MyPositionBean;
import com.example.myapplication.net.BitzApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

/**
 * 已平仓位
 */
public class MyPositionActivity extends AppCompatActivity {

    private RecyclerView activity_my_position_recy;
    private MyPositionAdapter myPositionAdapter;
    private BitzApi bitzApi;
    private ImageView src_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_position);
        initView();
        initAdapter();
        initNet();
        initOnclik();
    }

    private void initOnclik() {
        src_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initView() {

        activity_my_position_recy = (RecyclerView) findViewById(R.id.activity_my_position_recy);
        src_back = (ImageView) findViewById(R.id.src_back);

    }

    private void initAdapter() {

        myPositionAdapter = new MyPositionAdapter(this);
        activity_my_position_recy.setLayoutManager(new LinearLayoutManager(this));
        activity_my_position_recy.setAdapter(myPositionAdapter);
    }


    private void initNet() {
        bitzApi = new BitzApi("", "", "", MyPositionActivity.this);

        try {
            bitzApi.getMyPositions("101", "1", "50", new BitzApi.Result() {
                @Override
                public void getResult(String result) {
                    Log.i("test1111", result);
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
        MyPositionBean myPositionBean = gson.fromJson(result, MyPositionBean.class);
        List<MyPositionBean.DataBean> data = myPositionBean.getData();
        myPositionAdapter.setNewData(data);
    }
}
