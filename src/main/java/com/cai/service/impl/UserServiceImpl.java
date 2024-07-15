package com.cai.service.impl;

import com.cai.dao.UserMapper;
import com.cai.pojo.User;
import com.cai.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.cai.util.mybatisUtil.getSession;

public class UserServiceImpl implements UserService {
    /**
     * 分页查询
     * @param currentPage 当前页面
     * @param PageSize 每页显示的条数
     * @return
     */
    @Override
    public List<User> queryUserByPage(Integer currentPage, Integer PageSize) {
       //校验数据的合法性
        if(currentPage==null||PageSize==null)
        {
            throw new RuntimeException("传递的参数不能为空");
        }
        //根据索引计算初始索引
        //公式：（起始索引-1）*条数
        int beginIndex=(currentPage-1)*PageSize;
       //调用dao方法
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.FindUserByPage(beginIndex,PageSize);
    }

    /**
     *
     * @param id 用户id
     */
    @Override
    public void deleteUserById(Integer id) {
        //校验数据的合法性
        if(id==null)
        {
            throw new RuntimeException("传递的参数不能为空");
        }
        //调用dao方法
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int rowcount1= userMapper.DeleteUserByIdInUser_Role(id);
        int rowcount2= userMapper.DeleteUserByIdInUser(id);
        if(rowcount1>0&&rowcount2>0)
            System.out.println("删除成功");

    }

    /**
     * 实现更新逻辑
     * @param id
     */
    @Override
    public void update(Integer id) {
        //校验数据的合法性
        if(id==null)
        {
            throw new RuntimeException("传递的参数不能为空");
        }
        //调用dao方法
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<Integer, Integer>> mapList = userMapper.FindAllUser_RoleById(id);
        for (Map<Integer, Integer> integerIntegerMap : mapList) {
            System.out.println(integerIntegerMap);
        }
        User user=new User();
        userMapper.DeleteUserByIdInUser_Role(id);
        userMapper.UpdateUserById(user,10);
        userMapper.insertNewInUser_Role(user.getId(),"1");
        userMapper.insertNewInUser_Role(user.getId(),"2");

    }
}
