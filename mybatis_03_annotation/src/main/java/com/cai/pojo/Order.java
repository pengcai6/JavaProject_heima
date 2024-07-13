package com.cai.pojo;
/**
 * 订单表
 * 
 */
public class Order {

    private Integer id;//主键

    private String orderNumber;//订单编号
    //订单人
    private User Orderuser;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getOrderuser() {
        return Orderuser;
    }

    public void setOrderuser(User orderuser) {
        this.Orderuser = orderuser;
    }
}
