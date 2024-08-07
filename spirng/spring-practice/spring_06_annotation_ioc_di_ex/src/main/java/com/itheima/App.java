package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Goods;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        Order order = new Order();

        User user = new User();
        user.setUserName("Spring小助手");
        user.setAddress("编程大街201号");

        Goods goods = new Goods();
        goods.setGoodsName("《Spring百科全书》");
        goods.setNum(45);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder(order,user,goods);

    }
}
