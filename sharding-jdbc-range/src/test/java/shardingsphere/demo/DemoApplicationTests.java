package shardingsphere.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
    public void getByUserId(){
        List<Order> byUserId = orderMapper.findByUserId(20);
        for (Order order : byUserId) {
            System.out.println(order);
        }

    }

    @Test
    public void getBetween(){
        Map<String,Integer> param=new HashMap<>(2);
        param.put("min",1);
        param.put("max",100);
        List<Order> byUserIdBetween = orderMapper.findByUserIdBetween(param);
        for (Order order : byUserIdBetween) {
            System.out.println(order);
        }
    }




}
