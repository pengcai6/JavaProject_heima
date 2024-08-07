package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAop {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = ctx.getBean(OrderService.class);

        orderService.placeOrder();
        orderService.placeOrder();
        orderService.placeOrder();
        orderService.chargeback();
        orderService.placeOrder();
        orderService.chargeback();
        orderService.placeOrder();
        orderService.placeOrder();
        orderService.placeOrder();
        orderService.chargebackOver();
        orderService.chargeback();
        orderService.chargebackOver();
        orderService.chargebackOver();


    }
}
