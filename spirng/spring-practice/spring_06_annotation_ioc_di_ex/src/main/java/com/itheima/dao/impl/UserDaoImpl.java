package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void get(User user) {
        System.out.println("查询到用户："+user.getUserName()+" 的收货地址为："+user.getAddress()+"，此信息写入订单数据");
    }
}
