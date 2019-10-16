package com.example.myapplication.bean;

import java.util.List;

public class MyWeiTuoList {

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
         * orderId : 13179098
         * contractId : 101
         * amount : 11
         * price : 9716.07
         * type : limit
         * leverage : 2
         * direction : -1
         * orderStatus : 0
         * isCross : -1
         * available : 11
         * time : 1569327725
         * pair : BTC_USDT
         */

        private String orderId;
        private String contractId;
        private String amount;
        private String price;
        private String type;
        private String leverage;
        private String direction;
        private String orderStatus;
        private String isCross;
        private String available;
        private int time;
        private String pair;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getContractId() {
            return contractId;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLeverage() {
            return leverage;
        }

        public void setLeverage(String leverage) {
            this.leverage = leverage;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getIsCross() {
            return isCross;
        }

        public void setIsCross(String isCross) {
            this.isCross = isCross;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }
    }
}
