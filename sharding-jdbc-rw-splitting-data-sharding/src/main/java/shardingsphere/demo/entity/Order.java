package shardingsphere.demo.entity;

import java.io.Serializable;

/**
 * @author fengsihang
 * @date 2018/7/13
 */
public class Order implements Serializable {

    private Long id;

    private Integer userId;
    private Integer orderId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                '}';
    }
}
