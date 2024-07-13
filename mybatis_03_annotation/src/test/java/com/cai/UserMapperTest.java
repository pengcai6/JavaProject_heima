package com.cai;
import com.cai.dao.UserMapper;
import com.cai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static com.cai.util.mybatisUtil.getSession;

public class UserMapperTest {
    @Test
    public void findAllUserTest(){
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.FindAllUser();
        for (User user : userList) {
            System.out.println("用户信息"+user);
        }
        sqlSession.close();
    }
    @Test
    public void findUserByLike(){
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.FindUserByLike("张");
        for (User user : userList) {
            System.out.println("用户信息"+user);
        }
        sqlSession.close();
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = getSession();//开启自动事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUserName("1243");
        user.setAge(12);
        user.setName("123");
        user.setPassword("123");
        user.setSex(0);
        int rowCount = userMapper.addUser(user);
        if(rowCount>0)
        {
            System.out.println("插入成功");
        }
        sqlSession.close();
    }
    @Test
    public void addUserGePkTest(){
        SqlSession sqlSession = getSession();//开启自动事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUserName("李博");
        user.setAge(1);
        user.setName("123123");
        user.setPassword("123456");
        user.setSex(1);
        System.out.println(user);
        int rowCount = userMapper.addUserGetPk(user);
        if(rowCount>0)
        {
            System.out.println("插入成功");
        }
        System.out.println("主键回填后"+user);
        sqlSession.close();
    }


}
