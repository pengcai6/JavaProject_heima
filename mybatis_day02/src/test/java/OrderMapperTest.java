import com.cai.dao.OrderMapper;
import com.cai.pojo.Order;
import com.cai.pojo.OrderItem;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static com.cai.util.mybatisUtil.getSession;

public class OrderMapperTest {

    @Test
    public void addOrder(){
        SqlSession session = getSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order=new Order();
        order.setPayment(1000.0);
        order.setPaymentType(2);
        order.setStatus(1);
        int rowCount1 = orderMapper.addOrder(order);

        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setGoodsName("小米");
        orderItem.setGoodsPrice(1000);
        orderItem.setCount("10");
        int rowCount2 = orderMapper.addOrderItem(orderItem);
        if(rowCount1 >0&&rowCount2>0)
        {
            session.commit();
            System.out.println("订单生成完成");
        }
        session.close();
    }
}
