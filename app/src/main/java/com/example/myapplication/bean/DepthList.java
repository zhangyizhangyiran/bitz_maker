package com.example.myapplication.bean;

import java.util.List;

public class DepthList {
    /**
     * status : 200
     * msg :
     * data : {"bids":[{"price":"9996.0","amount":"1400"},{"price":"9990.9","amount":"2039"},{"price":"9990.8","amount":"4801"},{"price":"9990.3","amount":"1733"},{"price":"9990.2","amount":"1424"},{"price":"9990.1","amount":"3623"},{"price":"9989.7","amount":"2852"},{"price":"9989.6","amount":"993"},{"price":"9989.4","amount":"111"},{"price":"9985.6","amount":"1000"}],"asks":[{"price":"9996.1","amount":"29"},{"price":"9996.8","amount":"498"},{"price":"9996.9","amount":"190"},{"price":"9997.4","amount":"1299"},{"price":"9997.6","amount":"30"},{"price":"9998.3","amount":"355"},{"price":"9998.8","amount":"2530"},{"price":"9999.0","amount":"1635"},{"price":"9999.9","amount":"9"},{"price":"10000.0","amount":"60"}]}
     * time : 1569206533
     * microtime : 0.16538600 1569206533
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
        private List<BidsBean> bids;
        private List<AsksBean> asks;

        public List<BidsBean> getBids() {
            return bids;
        }

        public void setBids(List<BidsBean> bids) {
            this.bids = bids;
        }

        public List<AsksBean> getAsks() {
            return asks;
        }

        public void setAsks(List<AsksBean> asks) {
            this.asks = asks;
        }

        public static class BidsBean {
            /**
             * price : 9996.0
             * amount : 1400
             */

            private String price;
            private String amount;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }
        }

        public static class AsksBean {
            /**
             * price : 9996.1
             * amount : 29
             */

            private String price;
            private String amount;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }
        }
    }
}
