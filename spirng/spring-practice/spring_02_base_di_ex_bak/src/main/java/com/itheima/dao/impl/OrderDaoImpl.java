package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;

public class OrderDaoImpl implements OrderDao {

    public void save(Order order) {
        System.out.println("生成订单，商品库存数量已修改，用户收货地址已获取，订单生成成功");
    }
}
