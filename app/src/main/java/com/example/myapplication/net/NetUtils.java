package com.example.myapplication.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Configs;
import com.example.myapplication.utils.PreferencesUtils;
import com.example.myapplication.utils.SignUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class NetUtils {


    public void get(String url, Map<String, String> map, final result res, final Context context) {

        String apiKey = PreferencesUtils.getString(context, Configs.GONGYAO);
        String signinfo = PreferencesUtils.getString(context, Configs.SIYAO);

        //317ba457b877f9fa30ff8cac14d3e4a1
        //QekDNEXPkjdbQ1sy9XgIRWbTMtGfsfVDtVgAcUJYIvyH6ErU3KvsqBnSP5RnzyOw

        try {
            long timeStamp = System.currentTimeMillis();
            timeStamp = timeStamp / 1000;
            map.put("apiKey", apiKey);
            map.put("timeStamp", String.valueOf(timeStamp));
            map.put("nonce", String.valueOf(timeStamp).substring(0, 6));
            String sign = SignUtil.buildSign(map, signinfo);
            map.put("sign", sign);
            OkGo.<String>get(url).params(map).execute(new StringCallback() {

                @Override
                public void onSuccess(Response<String> response) {
                    Log.i("qwert", response.body().toString());
                    if (res != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().toString().trim());
                            int code = jsonObject.getInt("status");
                            if (code == 200) {
                                res.getResult(response.body().toString().trim());
                            } else {
                                res.getFaild(response.body().toString().trim());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    Toast.makeText(context, response.body(), Toast.LENGTH_SHORT).show();
                    if (res != null) {
                        res.getFaild("error");
                    }
                }
            });

        } catch (IllegalArgumentException e) {

        }
    }


    public void post(String url, HashMap<String, String> map, final result res, final Context context) {


        String apiKey = PreferencesUtils.getString(context, Configs.GONGYAO);
        String signinfo = PreferencesUtils.getString(context, Configs.SIYAO);

        Log.i("weuhwueg","apiKey=====>" + apiKey + "signinfo======>" + signinfo);


        long timeStamp = System.currentTimeMillis();
        timeStamp = timeStamp / 1000;
        map.put("apiKey", apiKey);
        map.put("timeStamp", String.valueOf(timeStamp));
        map.put("nonce", String.valueOf(timeStamp).substring(0, 6));
        String sign = SignUtil.buildSign(map, signinfo);
        map.put("sign", sign);

        try {

            OkGo.<String>post(url).params(map).execute(new StringCallback() {

                @Override
                public void onSuccess(Response<String> response) {
                    if (res != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().toString().trim());
                            int code = jsonObject.getInt("status");
                            if (code == 200) {
                                res.getResult(response.body().toString().trim());
                            } else {
                                res.getFaild(response.body().toString().trim());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);

                    if (res != null) {
                        res.getFaild("error");
                    }
                }
            });

        } catch (IllegalArgumentException e) {

        }
    }

    public interface result {
        void getResult(String result);
        void getFaild(String result);
    }
}
