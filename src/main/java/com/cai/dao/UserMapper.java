package com.cai.dao;

import com.cai.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 查询全部用户
     * @return 用户对象列表
     */
    @Select("select id, username, password, remark, email, createTime, updateTime from t_user")
    List<User> FindAllUser();

    /**
     * 插入数据
     * @param user 用户对象
     * @return 受影响行数
     */
    @Insert("insert into t_user (username, password, remark, email) " +
            "VALUES (#{username},#{password},#{remark},#{email})")
    int AddUser(User user);
    //不使用注解，使用xml开发

    /**
     * 分页查询用户以及角色信息
     * @param beginIndex 起始索引
     * @param size 查询条数
     * @return 用户对象列表
     */
    List<User> FindUserByPage(@Param("beginIndex") Integer beginIndex,
                              @Param("size") Integer size);

    /**
     * 根据id删除对应的用户
     * @param id 用户id
     * @return 受影响行数
     */
    int DeleteUserById(Integer id);
}
