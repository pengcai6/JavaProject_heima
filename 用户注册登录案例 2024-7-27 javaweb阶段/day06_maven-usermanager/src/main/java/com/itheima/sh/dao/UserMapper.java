package com.itheima.sh.dao;

import com.itheima.sh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
//1.创建接口
public interface UserMapper {
    //3.在方法上使用注解查询数据
    @Select("select * from user where username=#{username} and password=#{password}")
    //2.在接口中定义登陆方法
    User login(User user);

    @Select("select * from user where username=#{username}")
    User queryUserByUserName(String username);
    @Insert("insert into user values (null,#{username},#{password})")
    void registerUser(User user);
}
