package com.itheima;

import com.itheima.domain.Goods;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;

public class AppForDi {
    public static void main(String[] args) {
        Order order = new Order();
        User user = new User();
        Goods goods = new Goods();

        OrderService orderService = new OrderServiceImpl();
        orderService.placeOrder(order,user,goods);

    }
}
