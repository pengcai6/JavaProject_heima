package com.itheima.service;

import com.itheima.domain.Goods;
import com.itheima.domain.Order;
import com.itheima.domain.User;

public interface OrderService {
    public void placeOrder(Order order, User user, Goods goods);
}
