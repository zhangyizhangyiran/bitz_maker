package com.example.myapplication.bean;

import java.util.List;

public class ContractCoinBean {

    /**
     * Copyright 2019 bejson.com
     */

    private int status;
    private String msg;
    private List<CoinBean> data;
    private long time;
    private String microtime;
    private String source;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(List<CoinBean> data) {
        this.data = data;
    }

    public List<CoinBean> getData() {
        return data;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setMicrotime(String microtime) {
        this.microtime = microtime;
    }

    public String getMicrotime() {
        return microtime;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

}
