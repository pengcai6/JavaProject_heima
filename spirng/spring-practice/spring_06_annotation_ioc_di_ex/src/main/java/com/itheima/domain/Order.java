package com.itheima.domain;

public class Order {
    private Long id;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
