package shardingsphere.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shardingsphere.demo.entity.Order;
import shardingsphere.demo.mapper.OrderMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (int i =0; i <=20; i++) {
            for (int j = 0; j <= 30; j++) {
                order.setUserId(i);
                order.setOrderId(j);
                orderMapper.insert(order);
            }
        }
    }


    @Test
    public void getByMultiId(){
        Map<String,Integer> param=new HashMap<>(2);
        param.put("userId",1);
        param.put("orderId",30);
        List<Order> byMultiId = orderMapper.findByMultiId(param);
        for (Order order : byMultiId) {
            System.out.println(order);
        }
    }



}
