import com.cai.dao.UserMapper;
import com.cai.pojo.Role;
import com.cai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static com.cai.util.mybatisUtil.getSession;

public class UserMapperTest {
   @Test
    public  void FindAllUserTest()
    {
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.FindAllUser();
        for (User user : userList) {
            System.out.println("用户信息"+user);
        }
        sqlSession.close();
    }
    @Test
    public  void FindUserByPageTest()
    {
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.FindUserByPage(0,3);
        for (User user : userList) {
            System.out.println("用户信息:"+user);
            List<Role> roles=user.getRoles();
            for (Role role : roles) {
                System.out.println("角色信息:"+role);
            }
        }
        sqlSession.close();
    }
    @Test
    public  void AddUserTest()
    {
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("123");
        user.setPassword("456");
        user.setEmail("123");
        int rowCount = userMapper.AddUser(user);
       if(rowCount>0)
       {System.out.println("插入成功");}
        sqlSession.close();
    }
    @Test
   public void DeleteUserByIdInUser()
    {
        SqlSession sqlSession = getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int rowCount = userMapper.DeleteUserByIdInUser(2);
        if(rowCount>0)
            System.out.println("删除成功");
        sqlSession.close();
    }


}
