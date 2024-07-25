package com.cai.dao;

import com.cai.pojo.dish;
import org.apache.ibatis.annotations.Insert;

public interface dishMapper {
    /**
     * 添加菜品
     * @param dish
     * @return
     */
    @Insert("insert into dish(name, price, description) VALUES (#{name},#{price},#{description})")
    int add(dish dish);
}
