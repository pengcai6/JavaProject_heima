package com.cai;
import com.cai.dao.UserMapper;
import com.cai.pojo.Order;
import com.cai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static com.cai.util.mybatisUtil.getSession;

public class UserMapperTest {
    @Test
    public void findUserByIdTest(){
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println("用户信息"+user);
        List<Order> orderList = user.getOrders();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }


}
