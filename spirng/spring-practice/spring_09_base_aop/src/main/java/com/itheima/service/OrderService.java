package com.itheima.service;

public interface OrderService {
    /**
     * 下单
     */
    public void placeOrder();

    /**
     * 发起退单
     */
    public void chargeback();

    /**
     * 退单完成
     */
    public void chargebackOver();
}
