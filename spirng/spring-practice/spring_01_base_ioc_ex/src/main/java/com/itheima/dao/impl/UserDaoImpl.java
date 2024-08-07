package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {

    public boolean save(User user) {
        System.out.println("保存user数据："+user);
        return true;
    }
}
