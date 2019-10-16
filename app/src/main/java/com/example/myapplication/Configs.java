package com.example.myapplication;

public class Configs {

    public static String SIYAO = "siyao";
    public static String GONGYAO = "gongyao";

    //线上
//    public static String BASEUEL = "https://api.bitzapi.com";
    public static String BASEUEL = "https://apiv2.bitz.com";
//    public static String BASEUEL = "https://apiv2.bit-z.pro";

    //测试

    //获取账户信息
    public static String GETACCOUNTINFO = BASEUEL + "/Contract/getContractAccountInfo";
    //下单接口
    public static String GETPLACEORDER = BASEUEL + "/Contract/addContractTrade";
    //取消委托
    public static String CANCELORDE = BASEUEL + "/Contract/cancelContractTrade";
    //获取当前未平仓位
    public static String MYACTIVEPOSITIONS = BASEUEL + "/Contract/getContractActivePositions";
    //获取我的活动委托
    public static String ACTIVEORDERS = BASEUEL + "/Contract/getContractOrder";
    //获取合约交易市场列表
    public static String GETCONTRACTCOIN = BASEUEL + "/Market/getContractCoin";
    //    public static String GETCONTRACTCOIN = "https://apiv2.bitz.com/Market/getContractCoin";
    public static String CONTRACTORDERBOOK = BASEUEL + "/Market/getContractOrderBook";
    //合约详情
    public static String CONTRACTTICKERS = BASEUEL + "/Market/getContractTickers";

    //获取已平仓位列表
    public static String CONTRACTMYPOSITIONS = BASEUEL + "/Contract/getContractMyPositions";
    //获取当前仓位
    public static String CONTRACTACTIVEPOSITIONS = BASEUEL + "/Contract/getContractActivePositions";
    //合约交易取消委托
    public static String CANCELCONTRACTTRADE = BASEUEL + "/Contract/cancelContractTrade";


}
