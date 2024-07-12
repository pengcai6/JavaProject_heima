package com.cai.dao;

import com.cai.pojo.User;

public interface UserMapper {


     /**
      * 根据用户id查询用户信息以及下单信息
      * @param id 用户id
      * @return 用户对象
      */
     public User findUserById(Integer id);
}
