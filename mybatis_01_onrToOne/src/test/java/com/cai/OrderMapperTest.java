package com.cai;

import com.cai.dao.OrderMapper;
import com.cai.pojo.Order;
import com.cai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static com.cai.util.mybatisUtil.getSession;

public class OrderMapperTest {
    @Test
    public void testOneToOne()
    {
        SqlSession sqlSession = getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
         Order order= orderMapper.findOrderByNumber("20140921003");
        System.out.println("订单信息"+order);
         User user= order.getOrderuser();
        System.out.println("下单人信息："+user);
        sqlSession.close();
    }

}
