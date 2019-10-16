package com.example.myapplication;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpParams;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkgo();
    }

    private void initOkgo() {

//        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        //全局的读取超时时间
//        builder.readTimeout(600000, TimeUnit.MILLISECONDS);
//        //全局的写入超时时间
//        builder.writeTimeout(600000, TimeUnit.MILLISECONDS);
//        //全局的连接超时时间
//        builder.connectTimeout(600000, TimeUnit.MILLISECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.HEADERS);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.ALL);
//        builder.addInterceptor(loggingInterceptor);


        OkHttpClient build = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
//                .eventListenerFactory(HttpEventListener.FACTORY)

                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();


        HttpParams params = new HttpParams();
        long timeStamp = System.currentTimeMillis();
        timeStamp = timeStamp / 1000;
        params.put("timeStamp", String.valueOf(timeStamp));
        params.put("nonce", String.valueOf(timeStamp).substring(0, 6));


        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(build)               //建议设置OkHttpClient，不设置将使用默认的
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonParams(params);


    }
}
