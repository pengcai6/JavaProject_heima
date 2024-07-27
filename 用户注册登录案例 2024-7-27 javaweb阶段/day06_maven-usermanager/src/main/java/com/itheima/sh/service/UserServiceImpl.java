package com.itheima.sh.service;

import com.itheima.sh.dao.UserMapper;
import com.itheima.sh.pojo.User;
import com.itheima.sh.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl {
    //1.定义登陆方法接收web层传输的user对象，并返回给web层用户对象
    public User login(User user) {
    //2.在登陆方法中根据mybatis工具类获取mybatis会话对象
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    //3.使用会话对象调用方法获取dao层的接口代理对象
    UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
    //4.使用接口代理对象调用接口中的登陆方法，user做为传递
    User u=UserMapper.login(user);
    //5.释放资源
    sqlSession.close();
    //直接返回User对象
    return u;
    }
    //1.定义注册的方法接收web层传递的user对象
    public Boolean register(User user) {
        SqlSession sqlSession=null;
        try {
            //2.获取会话对象
            sqlSession = SqlSessionUtil.getSqlSession();
            //3.获取接口代理对象
            UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
            //4.使用接口代理对象调用接口中的根据用户名查询的方法
            String username = user.getUsername();
            User u = UserMapper.queryUserByUserName(username);
            //5.判断返回的User对象是否等于null
            if (u == null) {
                //6.如果等于null,说明没有查到，可以注册，使用接口代理对象调用注册方法
                UserMapper.registerUser(user);
                //7.提交事务 工具类自动提交
                //8.返回给web层true
                return true;
            } else {
                //9.如果查询的用户对象不等于null,说明用户存在，不能注册，返回给web层false
                return false;
            }
        } finally {
            //10.释放资源
            //防止空指针异常
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }


    }
}
