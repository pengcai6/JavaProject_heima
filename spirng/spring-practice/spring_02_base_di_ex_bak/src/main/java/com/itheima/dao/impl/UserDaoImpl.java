package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {

    public void get(Long id) {
        System.out.println("根据用户id查询到收货地址，此信息写入订单数据");
    }
}
