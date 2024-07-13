package com.cai.dao;

import com.cai.pojo.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

     /**
      * 插入用户
      * @param user 用户对象
      * @return 受影响行数
      */
     @Insert("insert into tb_user (user_name, password, name, age, sex) " +
             "values (#{userName},#{password},#{name},#{age},#{sex})")
     int insertUser(User user);

     /**
      * 根据用户id查询用户信息以及下单信息
      * @param id 用户id
      * @return 用户对象
      */
     User findUserById(Integer id);
}
