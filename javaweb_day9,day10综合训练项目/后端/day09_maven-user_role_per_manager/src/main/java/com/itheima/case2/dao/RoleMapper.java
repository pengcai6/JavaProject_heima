package com.itheima.case2.dao;

import com.itheima.case2.pojo.po.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    //TODO: 用户下拉框查询角色的方法
    @Select("select * from t_role")
    List<Role> findAllRose();
}
