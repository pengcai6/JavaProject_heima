package com.cai.dao;

import com.cai.pojo.Order;
import com.cai.pojo.OrderItem;

public interface OrderMapper {

    public int addOrder(Order order);
    public int addOrderItem(OrderItem orderItem);
}
