package shardingsphere.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shardingsphere.demo.entity.Order;
import shardingsphere.demo.mapper.OrderMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void add() {
        Order order = new Order();
        for (int i =0; i <=2; i++) {
            for (int j = 0; j <= 3; j++) {
                order.setUserId(i);
                order.setOrderId(j);
                orderMapper.insert(order);
            }
        }
    }

    @Test
    public void getByUserId(){
        List<Order> byUserId = orderMapper.findByUserId(20);
        for (Order order : byUserId) {
            System.out.println(order);
        }

    }


}
