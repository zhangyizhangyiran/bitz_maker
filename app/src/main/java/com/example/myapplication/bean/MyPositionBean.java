package com.example.myapplication.bean;

import java.util.List;

public class MyPositionBean {


    private int status;
    private String msg;
    private int time;
    private String microtime;
    private String source;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMicrotime() {
        return microtime;
    }

    public void setMicrotime(String microtime) {
        this.microtime = microtime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * positionId : 2161
         * contractId : 101
         * rlzPnl : -5.50345234
         * startTime : 1568711900
         * endTime : 1568862200
         * pair : BTC_USDT
         */

        private String positionId;
        private String contractId;
        private String rlzPnl;
        private int startTime;
        private int endTime;
        private String pair;

        public String getPositionId() {
            return positionId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
        }

        public String getContractId() {
            return contractId;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public String getRlzPnl() {
            return rlzPnl;
        }

        public void setRlzPnl(String rlzPnl) {
            this.rlzPnl = rlzPnl;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }
    }
}
