package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {

    public void get(User user) {
        System.out.println("查询到用户："+user.getUserName()+" 的收货地址为："+user.getAddress()+"，此信息写入订单数据");
    }
}
