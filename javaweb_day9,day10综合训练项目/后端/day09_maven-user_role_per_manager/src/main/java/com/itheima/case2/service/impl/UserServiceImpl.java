package com.itheima.case2.service.impl;

import com.itheima.case2.dao.UserMapper;
import com.itheima.case2.pojo.po.User;
import com.itheima.case2.pojo.vo.AddUser;
import com.itheima.case2.pojo.vo.PageResult;
import com.itheima.case2.pojo.vo.QueryPageBean;
import com.itheima.case2.pojo.vo.UpdateUser;
import com.itheima.case2.service.UserService;
import com.itheima.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    //分页查询用户
    @Override
    public PageResult findAll(QueryPageBean pb) {
    //2.获取mybatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();
        //3.获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.使用接口代理对象调用接口中分页查询用户方法
       //调用方法获取起始索引
        //select * from 表名 limit 起始索引数，每页条数
        Integer startIndex = pb.getOffset();
        //获取每页条数
        Integer pageSize = pb.getPageSize();
        List<User> List = mapper.findAll(startIndex,pageSize);
        //5.使用接口代理对象调用接口中查询总记录数方法
        long total=mapper.findCount();
        //6.创建存储查询结果的实体类对象
        PageResult pageResult = new PageResult(total,List);
        //7.关闭会话
        sqlSession.close();
        //8.将结果对象返回给web层
        return pageResult;
    }
    //更新用户
    @Override
    public void update(UpdateUser updateUser) {
        //1.获取mybatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.使用接口代理对象调用接口中更新用户表t_user的数据
        mapper.update(updateUser);
        //4.使用接口代理对象调用接口中根据用户id删除用户表t_user_role的数据
        mapper.deleteFromUserAndRoleTableByUId(updateUser.getId());
        //5.使用接口代理对象调用接口中根据用户id添加用户表t_user_role的数据
        mapper.addUIDAndRIDToUserAndRoleTable(updateUser.getId(),updateUser.getRoleIds());
        //5.关闭会话
        sqlSession.close();
    }
    //添加用户
    @Override
    public void add(AddUser addUser) {
        //1.获取mybatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.使用接口代理对象调用接口中添加用户表t_user的数据
        mapper.add(addUser);
        //4.使用接口代理对象调用接口中根据用户id删除用户表t_user_role的数据
        mapper.deleteFromUserAndRoleTableByUId(addUser.getId());
        //5.使用接口代理对象调用接口中根据用户id添加用户表t_user_role的数据
        mapper.addUIDAndRIDToUserAndRoleTable(addUser.getId(),addUser.getRoleIds());
        //6.关闭会话
        sqlSession.close();
    }
    //根据id删除用户
    @Override
    public void delete(Integer uid) {
        //1.获取mybatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();
        //2.获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //先删除用户表t_user_role的数据解除外键约束
        //3.使用接口代理对象调用接口中根据用户id删除用户表t_user_role的数据
        mapper.deleteFromUserAndRoleTableByUId(uid);
        //4.使用接口代理对象调用接口中删除用户表t_user的数据
        mapper.delete(uid);
        //5.关闭会话
        sqlSession.close();
    }
}
