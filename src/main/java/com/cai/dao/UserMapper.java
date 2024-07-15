package com.cai.dao;

import com.cai.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询全部用户
     * @return 用户对象列表
     */
    @Select("select id, username, password, remark, email, createTime, updateTime from t_user")
    List<User> FindAllUser();


    /**
     * 通过id查询用户信息
     * @param  user_id 用户id
     * @return 用户对象列表
     */
    @Select("select user_id, role_id from t_user_role where user_id=#{user_id}")
    List<Map<Integer,Integer>> FindAllUser_RoleById(Integer user_id);
    @Update("update t_user set  username =#{username} , password=#{password}, remark=#{remark}, email=#{email}, createTime=#{createTime}, updateTime=#{updateTime} where id=#{id}")
    @Options(
            useGeneratedKeys = true,keyColumn = "id",keyProperty = "id"
    )
    int UpdateUserById(User user);


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
    @Delete("delete from t_user where id=#{id}")
    int DeleteUserByIdInUser(Integer id);

    @Delete("delete from t_user_role where user_id=#{id}")
    int DeleteUserByIdInUser_Role(Integer id);

    @Insert("Insert t_user_role(user_id, role_id) values ( #{user_id}, #{role_id})")
    int insertNewInUser_Role(@Param("user_id") String user_id,@Param("role_id") String role_id);

    @Select( "select * from t_user where id=#{id}")
    User findUserByid(Integer id);
}
