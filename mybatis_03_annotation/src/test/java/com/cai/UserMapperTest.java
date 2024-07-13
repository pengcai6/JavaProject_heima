package com.cai;
import com.cai.dao.UserMapper;
import com.cai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static com.cai.util.mybatisUtil.getSession;

public class UserMapperTest {
    @Test
    public void findUserByIdTest(){
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println("用户信息"+user);
    }
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = getSession();//开启自动事务
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUserName("123");
        user.setAge(12);
        user.setName("123");
        user.setPassword("123");
        user.setSex(0);
        int rowCount = userMapper.insertUser(user);
        if(rowCount>0)
        {
            System.out.println("插入成功");
        }
        sqlSession.close();
    }


}
