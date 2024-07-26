import com.cai.dao.dishMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.cai.pojo.dish;

import static com.cai.util.mybatisUtil.getSession;

public class test {
    @Test
    public void test1(){
        dish dish = new dish(16.5,"蔡","不错");

        SqlSession sqlSession = getSession();
        dishMapper dishMapper = sqlSession.getMapper(dishMapper.class);
        System.out.println(dish);
        int add = dishMapper.add(dish);
        if(add>0){
            sqlSession.commit();
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
        sqlSession.close();
    }
}
