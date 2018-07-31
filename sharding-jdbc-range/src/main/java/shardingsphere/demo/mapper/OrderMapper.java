package shardingsphere.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shardingsphere.demo.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @author fengsihang
 * @date 2018/7/13
 */
@Mapper
@Repository
public interface OrderMapper {

    /**
     * insert
     *
     * @param order
     */
    void insert(Order order);

    /**
     * userID
     *
     * @param id
     * @return
     */
    List<Order> findByUserId(Integer id);

    List<Order> findByUserIdBetween(Map<String, Integer> map);

    /**
     * orderID
     *
     * @param id
     * @return
     */
    List<Order> findByOrderId(Integer id);

}
