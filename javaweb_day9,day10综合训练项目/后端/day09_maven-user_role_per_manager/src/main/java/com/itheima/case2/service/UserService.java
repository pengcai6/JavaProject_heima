package com.itheima.case2.service;

import com.itheima.case2.pojo.vo.AddUser;
import com.itheima.case2.pojo.vo.PageResult;
import com.itheima.case2.pojo.vo.QueryPageBean;
import com.itheima.case2.pojo.vo.UpdateUser;

public interface UserService {
    //分页查询
    public PageResult findAll(QueryPageBean pb);
    //更新用户
    void update(UpdateUser updateUser);
    //添加用户
    void add(AddUser addUser);
    //删除用户
    void delete(Integer uid);
}
