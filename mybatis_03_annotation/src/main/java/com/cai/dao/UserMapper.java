package com.cai.dao;

import com.cai.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

     /**
      * 插入用户
      * @param user 用户对象
      * @return 受影响行数
      */
     @Insert("insert into tb_user (user_name, password, name, age, sex) " +
             "values (#{userName},#{password},#{name},#{age},#{sex})")
     int addUser(User user);
     @Insert("insert into tb_user (user_name, password, name, age, sex) " +
             "values (#{userName},#{password},#{name},#{age},#{sex})")
     @Options(useGeneratedKeys = true ,keyColumn = "id",keyProperty = "id")
     //开启主键回填：useGeneratedKeys = true 表中字段名 keyColumn = "id", 实体类中的属性名： keyProperty = "id"
     int addUserGetPk(User user);


     /**
      * 查询所有用户
      * @return 用户对象列表
      */
     @Select("select id as user_id, user_name, password, name, age, sex from tb_user")
     @Results(
             id = "useMap",
             value = {
                     @Result(column = "user_id",property = "id" ,id=true),
                     @Result(column = "user_name",property = "userName")
             }
     )
     List<User> FindAllUser();

     /**
      * 根据给定的名字模糊查询拥用户数据
      * @param name 名字
      * @return 存储用户对象的列表
      */
     @Select("SELECT  id , user_name as userName, password, name, age,sex " +
             "FROM tb_user WHERE sex = 1 and name like  concat('%',#{name},'%') ")
     List<User> FindUserByLike(String name);

}
