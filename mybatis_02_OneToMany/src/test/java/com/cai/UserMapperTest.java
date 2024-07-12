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
        System.out.println(user);
    }


}
