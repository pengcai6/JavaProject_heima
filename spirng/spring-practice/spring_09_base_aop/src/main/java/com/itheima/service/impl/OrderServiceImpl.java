package com.itheima.service.impl;

import com.itheima.service.OrderService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    public void placeOrder() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now =  df.format(new Date());
        System.out.println(now+" 下单成功");
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chargeback() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now =  df.format(new Date());
        System.out.println(now+" 发起退单操作");
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chargebackOver() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now =  df.format(new Date());
        System.out.println(now+" 退单完成");
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
