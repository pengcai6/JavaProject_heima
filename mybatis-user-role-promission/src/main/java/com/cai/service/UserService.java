package com.cai.service;

import com.cai.pojo.User;

import java.util.List;

//业务层：业务接口（制定规则）
public interface UserService {
    /**
     *分页查询
     * @param currentPage 当前页面
     * @param PageSize 每页显示的条数
     * @return
     */
    List<User> queryUserByPage(Integer currentPage,Integer PageSize);

    /**
     * 通过id删除用户数据
     * @param id 用户id
     */
    void deleteUserById(Integer id);

    /**
     * 通过id更新
     * @param id
     */
    void update(Integer id);

}
