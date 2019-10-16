package com.example.myapplication.bean;

import java.util.List;

public class MyActivePOsitionsBean {

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
         * price : 9754.22
         * direction : -1
         * amount : 2
         * liquidationPrice : 10205.18
         * rlzPnl : -0.01072972
         * unrlzPnl : 0.00830006
         * margin : 1.04500581
         * leverage : 20.00000000
         * isCross : -1
         * pair : BTC_USDT
         */

        private String positionId;
        private String contractId;
        private String price;
        private String direction;
        private String amount;
        private String liquidationPrice;
        private String rlzPnl;
        private String unrlzPnl;
        private String margin;
        private String leverage;
        private String isCross;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getLiquidationPrice() {
            return liquidationPrice;
        }

        public void setLiquidationPrice(String liquidationPrice) {
            this.liquidationPrice = liquidationPrice;
        }

        public String getRlzPnl() {
            return rlzPnl;
        }

        public void setRlzPnl(String rlzPnl) {
            this.rlzPnl = rlzPnl;
        }

        public String getUnrlzPnl() {
            return unrlzPnl;
        }

        public void setUnrlzPnl(String unrlzPnl) {
            this.unrlzPnl = unrlzPnl;
        }

        public String getMargin() {
            return margin;
        }

        public void setMargin(String margin) {
            this.margin = margin;
        }

        public String getLeverage() {
            return leverage;
        }

        public void setLeverage(String leverage) {
            this.leverage = leverage;
        }

        public String getIsCross() {
            return isCross;
        }

        public void setIsCross(String isCross) {
            this.isCross = isCross;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }
    }
}
