package com.cai.service.impl;

import com.cai.dao.UserMapper;
import com.cai.pojo.User;
import com.cai.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}
