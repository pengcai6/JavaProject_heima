package com.cai.dao;

import com.cai.pojo.Order;

public interface OrderMapper {
    /**
     * 根据给定的订单编号，查询订单信息以及下单人信息
     * @param orderNumber 订单编号
     * @return  订单对象
     */
    Order findOrderByNumber(String orderNumber );
}
