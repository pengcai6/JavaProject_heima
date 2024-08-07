package com.itheima.service.impl;

import com.itheima.dao.GoodsDao;
import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.GoodsDaoImpl;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.Goods;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();

    public void placeOrder(Order order, User user, Goods goods) {
        userDao.get(user.getId());
        goodsDao.updateNum(goods);
        orderDao.save(order);
    }
}
