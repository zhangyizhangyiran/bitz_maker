package com.example.myapplication.bean;

import java.util.List;

public class TickersBean {

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

        private String contractId;
        private String pair;
        private String min;
        private String max;
        private String latest;
        private String change24h;
        private String amount;
        private String volumn;
        private String baseAmount;
        private String quoteVolumn;
        private String openInterest;
        private String indexPrice;
        private String fairPrice;
        private String nextFundingRate;

        public String getContractId() {
            return contractId;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getLatest() {
            return latest;
        }

        public void setLatest(String latest) {
            this.latest = latest;
        }

        public String getChange24h() {
            return change24h;
        }

        public void setChange24h(String change24h) {
            this.change24h = change24h;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getVolumn() {
            return volumn;
        }

        public void setVolumn(String volumn) {
            this.volumn = volumn;
        }

        public String getBaseAmount() {
            return baseAmount;
        }

        public void setBaseAmount(String baseAmount) {
            this.baseAmount = baseAmount;
        }

        public String getQuoteVolumn() {
            return quoteVolumn;
        }

        public void setQuoteVolumn(String quoteVolumn) {
            this.quoteVolumn = quoteVolumn;
        }

        public String getOpenInterest() {
            return openInterest;
        }

        public void setOpenInterest(String openInterest) {
            this.openInterest = openInterest;
        }

        public String getIndexPrice() {
            return indexPrice;
        }

        public void setIndexPrice(String indexPrice) {
            this.indexPrice = indexPrice;
        }

        public String getFairPrice() {
            return fairPrice;
        }

        public void setFairPrice(String fairPrice) {
            this.fairPrice = fairPrice;
        }

        public String getNextFundingRate() {
            return nextFundingRate;
        }

        public void setNextFundingRate(String nextFundingRate) {
            this.nextFundingRate = nextFundingRate;
        }
    }
}
