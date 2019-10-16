package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.util.HashMap;

public class StrategyActivity extends AppCompatActivity {

    private EditText activity_strategy_ed_count;
    private EditText activity_strategy_ed_time;
    private EditText activity_strategy_ed_max_count;
    private EditText activity_strategy_ed_gangagn;
    private MaterialButton activity_strategy_but_baocun;
    private ImageView src_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);

        initView();
        initOncilk();

    }

    private void initOncilk() {


        src_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        activity_strategy_but_baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmpty();
            }
        });

    }

    private void checkEmpty() {
        String count = activity_strategy_ed_count.getText().toString().trim();
        String times = activity_strategy_ed_time.getText().toString().trim();
        String max_count = activity_strategy_ed_max_count.getText().toString().trim();
        String ganggan = activity_strategy_ed_gangagn.getText().toString().trim();


        if (TextUtils.isEmpty(count)) {

            Toast.makeText(this, "张数不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(times)) {

            Toast.makeText(this, "时间间隔不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(max_count)) {

            Toast.makeText(this, "最大张数不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(ganggan)) {

            Toast.makeText(this, "杠杆不能为空", Toast.LENGTH_SHORT).show();
            return;
        }


        HashMap<String, String> map = new HashMap<>();
        map.put("count", count);
        map.put("times", times);
        map.put("max_count", max_count);
        map.put("ganggan", ganggan);
        Gson gson = new Gson();
        String s = gson.toJson(map);

        //数据是使用Intent返回
        Intent intent = new Intent();
        //把返回数据存入Intent
        intent.putExtra("result", s);
        //设置返回数据
        this.setResult(200, intent);
        finish();


    }

    private void initView() {
        src_back = (ImageView) findViewById(R.id.src_back);
        activity_strategy_ed_count = (EditText) findViewById(R.id.activity_strategy_ed_count);
        activity_strategy_ed_time = (EditText) findViewById(R.id.activity_strategy_ed_time);
        activity_strategy_ed_max_count = (EditText) findViewById(R.id.activity_strategy_ed_max_count);
        activity_strategy_ed_gangagn = (EditText) findViewById(R.id.activity_strategy_ed_gangagn);
        activity_strategy_but_baocun = (MaterialButton) findViewById(R.id.activity_strategy_but_baocun);
    }
}
