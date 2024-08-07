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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao ;
    @Autowired
    private GoodsDao goodsDao ;

    public void placeOrder(Order order, User user, Goods goods) {
        userDao.get(user);
        goodsDao.updateNum(goods);
        orderDao.save(order);
    }
}
