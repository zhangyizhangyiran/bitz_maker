package com.example.myapplication.bean;

import java.util.List;

public class ContractDetailsBean {

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
        private String symbol;
        private String settleAnchor;
        private String quoteAnchor;
        private String contractAnchor;
        private String contractValue;
        private String pair;
        private String expiry;
        private String maxLeverage;
        private String maintanceMargin;
        private String makerFee;
        private String takerFee;
        private String settleFee;
        private String priceDec;
        private String anchorDec;
        private String status;
        private String isreverse;
        private String allowCross;
        private String allowLeverages;
        private String maxOrderNum;
        private String maxAmount;
        private String minAmount;
        private String maxPositionAmount;

        public String getContractId() {
            return contractId;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSettleAnchor() {
            return settleAnchor;
        }

        public void setSettleAnchor(String settleAnchor) {
            this.settleAnchor = settleAnchor;
        }

        public String getQuoteAnchor() {
            return quoteAnchor;
        }

        public void setQuoteAnchor(String quoteAnchor) {
            this.quoteAnchor = quoteAnchor;
        }

        public String getContractAnchor() {
            return contractAnchor;
        }

        public void setContractAnchor(String contractAnchor) {
            this.contractAnchor = contractAnchor;
        }

        public String getContractValue() {
            return contractValue;
        }

        public void setContractValue(String contractValue) {
            this.contractValue = contractValue;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {
            this.expiry = expiry;
        }

        public String getMaxLeverage() {
            return maxLeverage;
        }

        public void setMaxLeverage(String maxLeverage) {
            this.maxLeverage = maxLeverage;
        }

        public String getMaintanceMargin() {
            return maintanceMargin;
        }

        public void setMaintanceMargin(String maintanceMargin) {
            this.maintanceMargin = maintanceMargin;
        }

        public String getMakerFee() {
            return makerFee;
        }

        public void setMakerFee(String makerFee) {
            this.makerFee = makerFee;
        }

        public String getTakerFee() {
            return takerFee;
        }

        public void setTakerFee(String takerFee) {
            this.takerFee = takerFee;
        }

        public String getSettleFee() {
            return settleFee;
        }

        public void setSettleFee(String settleFee) {
            this.settleFee = settleFee;
        }

        public String getPriceDec() {
            return priceDec;
        }

        public void setPriceDec(String priceDec) {
            this.priceDec = priceDec;
        }

        public String getAnchorDec() {
            return anchorDec;
        }

        public void setAnchorDec(String anchorDec) {
            this.anchorDec = anchorDec;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIsreverse() {
            return isreverse;
        }

        public void setIsreverse(String isreverse) {
            this.isreverse = isreverse;
        }

        public String getAllowCross() {
            return allowCross;
        }

        public void setAllowCross(String allowCross) {
            this.allowCross = allowCross;
        }

        public String getAllowLeverages() {
            return allowLeverages;
        }

        public void setAllowLeverages(String allowLeverages) {
            this.allowLeverages = allowLeverages;
        }

        public String getMaxOrderNum() {
            return maxOrderNum;
        }

        public void setMaxOrderNum(String maxOrderNum) {
            this.maxOrderNum = maxOrderNum;
        }

        public String getMaxAmount() {
            return maxAmount;
        }

        public void setMaxAmount(String maxAmount) {
            this.maxAmount = maxAmount;
        }

        public String getMinAmount() {
            return minAmount;
        }

        public void setMinAmount(String minAmount) {
            this.minAmount = minAmount;
        }

        public String getMaxPositionAmount() {
            return maxPositionAmount;
        }

        public void setMaxPositionAmount(String maxPositionAmount) {
            this.maxPositionAmount = maxPositionAmount;
        }
    }
}
