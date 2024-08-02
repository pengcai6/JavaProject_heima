package com.itheima.case2.dao;


import com.itheima.case2.pojo.po.User;
import com.itheima.case2.pojo.vo.AddUser;
import com.itheima.case2.pojo.vo.UpdateUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //查询用户表的总记录数
    @Select("select count(*) from t_user")
    long findCount();
    //分页查询用户和角色信息
    List<User> findAll(@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);


    //更新用户表t_user的数据
    @Update("update t_user set username=#{username},email=#{email},password=#{password} where id=#{id}")
    void update(UpdateUser updateUser);
   // 根据用户id删除用户表t_user_role的数据
    @Delete("delete from t_user_role where user_id=#{uid}")
    void deleteFromUserAndRoleTableByUId(@Param("uid") Integer id);
    //根据用户id添加用户表t_user_role的数据
    //TODO:第二个参数存放的是多个角色id，需要使用动态sql
    void addUIDAndRIDToUserAndRoleTable(@Param("uid") Integer id,@Param("roleIds") List<String> roleIds);
    //添加用户信息到t_user的数据
    @Insert("insert into t_user (id, username, password, remark, email, createTime, updateTime)values(null,#{username},#{password},#{remark},#{email},DEFAULT,DEFAULT)")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void add(AddUser addUser);

    //根据id删除用户
    @Delete("delete from t_user where id=#{uid}")
    void delete(@Param("uid") Integer uid);
}
