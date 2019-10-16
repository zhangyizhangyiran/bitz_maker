package com.example.myapplication.bean;

import java.util.List;

public class AccountInfoBean {


    /**
     * status : 200
     * msg :
     * data : {"time":1569241611,"estimate_BTC":"0.00000000","estimate_USD":"0.00","estimate_CNY":"0.00","balances":[{"coin":"USDT","balance":"0.00000000","positionMargin":"0.00000000","orderMargin":"0.00000000","unrlzPnl":"0.00000000","total":"0.00000000","estimate_BTC":"0.00000000","estimate_USD":"0.00","estimate_CNY":"0.00"},{"coin":"BZ","balance":"0.00000000","positionMargin":"0.00000000","orderMargin":"0.00000000","unrlzPnl":"0.00000000","total":"0.00000000","estimate_BTC":"0.00000000","estimate_USD":"0.00","estimate_CNY":"0.00"}]}
     * time : 1569241611
     * microtime : 0.76364900 1569241611
     * source : api
     */

    private int status;
    private String msg;
    private DataBean data;
    private int time;
    private String microtime;
    private String source;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * time : 1569241611
         * estimate_BTC : 0.00000000
         * estimate_USD : 0.00
         * estimate_CNY : 0.00
         * balances : [{"coin":"USDT","balance":"0.00000000","positionMargin":"0.00000000","orderMargin":"0.00000000","unrlzPnl":"0.00000000","total":"0.00000000","estimate_BTC":"0.00000000","estimate_USD":"0.00","estimate_CNY":"0.00"},{"coin":"BZ","balance":"0.00000000","positionMargin":"0.00000000","orderMargin":"0.00000000","unrlzPnl":"0.00000000","total":"0.00000000","estimate_BTC":"0.00000000","estimate_USD":"0.00","estimate_CNY":"0.00"}]
         */

        private String time;
        private String estimate_BTC;
        private String estimate_USD;
        private String estimate_CNY;
        private List<BalancesBean> balances;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getEstimate_BTC() {
            return estimate_BTC;
        }

        public void setEstimate_BTC(String estimate_BTC) {
            this.estimate_BTC = estimate_BTC;
        }

        public String getEstimate_USD() {
            return estimate_USD;
        }

        public void setEstimate_USD(String estimate_USD) {
            this.estimate_USD = estimate_USD;
        }

        public String getEstimate_CNY() {
            return estimate_CNY;
        }

        public void setEstimate_CNY(String estimate_CNY) {
            this.estimate_CNY = estimate_CNY;
        }

        public List<BalancesBean> getBalances() {
            return balances;
        }

        public void setBalances(List<BalancesBean> balances) {
            this.balances = balances;
        }

        public static class BalancesBean {
            /**
             * coin : USDT
             * balance : 0.00000000
             * positionMargin : 0.00000000
             * orderMargin : 0.00000000
             * unrlzPnl : 0.00000000
             * total : 0.00000000
             * estimate_BTC : 0.00000000
             * estimate_USD : 0.00
             * estimate_CNY : 0.00
             */

            private String coin;
            private String balance;
            private String positionMargin;
            private String orderMargin;
            private String unrlzPnl;
            private String total;
            private String estimate_BTC;
            private String estimate_USD;
            private String estimate_CNY;

            public String getCoin() {
                return coin;
            }

            public void setCoin(String coin) {
                this.coin = coin;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getPositionMargin() {
                return positionMargin;
            }

            public void setPositionMargin(String positionMargin) {
                this.positionMargin = positionMargin;
            }

            public String getOrderMargin() {
                return orderMargin;
            }

            public void setOrderMargin(String orderMargin) {
                this.orderMargin = orderMargin;
            }

            public String getUnrlzPnl() {
                return unrlzPnl;
            }

            public void setUnrlzPnl(String unrlzPnl) {
                this.unrlzPnl = unrlzPnl;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getEstimate_BTC() {
                return estimate_BTC;
            }

            public void setEstimate_BTC(String estimate_BTC) {
                this.estimate_BTC = estimate_BTC;
            }

            public String getEstimate_USD() {
                return estimate_USD;
            }

            public void setEstimate_USD(String estimate_USD) {
                this.estimate_USD = estimate_USD;
            }

            public String getEstimate_CNY() {
                return estimate_CNY;
            }

            public void setEstimate_CNY(String estimate_CNY) {
                this.estimate_CNY = estimate_CNY;
            }
        }
    }


}
