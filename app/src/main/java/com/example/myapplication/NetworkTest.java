package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.net.BitzApi;
import com.example.myapplication.net.NetUtils;

import java.io.IOException;
import java.util.HashMap;

public class NetworkTest extends AppCompatActivity {

    private TextView net_one;
    private TextView net_two;
    private TextView net_three;
    private TextView net_four;
    private TextView net_fine;
    private TextView net_one_set;
    private TextView net_two_set;
    private TextView net_three_set;
    private TextView net_four_set;
    private TextView net_fine_set;
    private BitzApi bitzApi;
    private ImageView src_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);
        initNet();
        initView();
        initOnclik();
    }

    private void initNet() {
        bitzApi = new BitzApi("", "", "", NetworkTest.this);

    }

    private void initView() {
        net_one = (TextView) findViewById(R.id.net_one);
        net_two = (TextView) findViewById(R.id.net_two);
        net_three = (TextView) findViewById(R.id.net_three);
        net_four = (TextView) findViewById(R.id.net_four);
        net_fine = (TextView) findViewById(R.id.net_fine);

        net_one_set = (TextView) findViewById(R.id.net_one_set);
        net_two_set = (TextView) findViewById(R.id.net_two_set);
        net_three_set = (TextView) findViewById(R.id.net_three_set);
        net_four_set = (TextView) findViewById(R.id.net_four_set);
        net_fine_set = (TextView) findViewById(R.id.net_fine_set);
        src_back = (ImageView) findViewById(R.id.src_back);


    }


    private void initOnclik() {

        src_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        net_one_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Configs.setBASERL("https://apiv2.bitz.com");
                Toast.makeText(NetworkTest.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        net_two_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Configs.setBASERL("https://apiv2.bit-z.pro");
                Toast.makeText(NetworkTest.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        net_three_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Configs.setBASERL("https://api.bitzapi.com");
                Toast.makeText(NetworkTest.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        net_four_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Configs.setBASERL("https://api.bitzoverseas.com");
                Toast.makeText(NetworkTest.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        net_fine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Configs.setBASERL("https://api.bitzspeed.com");
                Toast.makeText(NetworkTest.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        net_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GETCONTRACTCOIN = "https://apiv2.bitz.com" + "/Market/getContractCoin";
                TestNet(GETCONTRACTCOIN);

            }
        });

        net_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GETCONTRACTCOIN = "https://apiv2.bit-z.pro" + "/Market/getContractCoin";
                TestNet(GETCONTRACTCOIN);
            }
        });


        net_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GETCONTRACTCOIN = "https://api.bitzapi.com" + "/Market/getContractCoin";
                TestNet(GETCONTRACTCOIN);
            }
        });


        net_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GETCONTRACTCOIN = "https://api.bitzoverseas.com" + "/Market/getContractCoin";
                TestNet(GETCONTRACTCOIN);
            }
        });


        net_fine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GETCONTRACTCOIN = "https://api.bitzspeed.com" + "/Market/getContractCoin";
                TestNet(GETCONTRACTCOIN);
            }
        });


    }

    private void TestNet(String baseurl) {
//        try {
//            bitzApi.getMxDataAontracts("101", new BitzApi.Result() {
//                @Override
//                public void getResult(String result) {
//                    Toast.makeText(NetworkTest.this, "网络可用", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void getFaild(String result) {
//                    Toast.makeText(NetworkTest.this, "网络不可用", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(NetworkTest.this, "网络不可用", Toast.LENGTH_SHORT).show();
//        }

        Log.i("woeufgqouweyrgf", baseurl);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("contractId", "101");

        new NetUtils().get(Configs.GETCONTRACTCOIN, params, new NetUtils.result() {
            @Override
            public void getResult(String result) {
                Toast.makeText(NetworkTest.this, "网络可用", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void getFaild(String result) {
                Toast.makeText(NetworkTest.this, "网络不可用", Toast.LENGTH_SHORT).show();

            }
        }, this);

    }


}
