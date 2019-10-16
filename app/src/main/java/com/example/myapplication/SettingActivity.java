package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.net.NetUtils;
import com.example.myapplication.utils.PreferencesUtils;

import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {

    private EditText activity_setting_ed_gongyao;
    private EditText activity_setting_ed_siyao;
    private AppCompatButton activity_setting_but_ok;
    private ImageView src_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initOncilk();
    }

    private void initView() {
        activity_setting_ed_gongyao = (EditText) findViewById(R.id.activity_setting_ed_gongyao);
        activity_setting_ed_siyao = (EditText) findViewById(R.id.activity_setting_ed_siyao);
        activity_setting_but_ok = (AppCompatButton) findViewById(R.id.activity_setting_but_ok);
        src_back = (ImageView) findViewById(R.id.src_back);
    }

    private void initOncilk() {


        src_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        activity_setting_but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gongyao = activity_setting_ed_gongyao.getText().toString();
                if (TextUtils.isEmpty(gongyao)) {
                    Toast.makeText(SettingActivity.this, "公钥不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String siyao = activity_setting_ed_siyao.getText().toString();
                if (TextUtils.isEmpty(siyao)) {
                    Toast.makeText(SettingActivity.this, "私钥不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                PreferencesUtils.putString(SettingActivity.this, Configs.GONGYAO, gongyao);
                PreferencesUtils.putString(SettingActivity.this, Configs.SIYAO, siyao);

                goMain();

            }
        });
    }

    private void goMain() {


        HashMap<String, String> params = new HashMap<String, String>();
        params.put("contractId", "101");

        new NetUtils().get(Configs.GETCONTRACTCOIN, params, new NetUtils.result() {
            @Override
            public void getResult(String result) {
                Toast.makeText(SettingActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(SettingActivity.this, MainActivity.class));
            }

            @Override
            public void getFaild(String result) {
                Toast.makeText(SettingActivity.this, "设置失败", Toast.LENGTH_SHORT).show();

            }
        }, this);
    }
}
