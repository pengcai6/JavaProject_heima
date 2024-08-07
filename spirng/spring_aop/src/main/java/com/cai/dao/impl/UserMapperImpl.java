package com.cai.dao.impl;

import com.cai.dao.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public Integer save(String name) {
        int i=1/0;
        System.out.println("UserDao save");
        return 100;
    }
}
