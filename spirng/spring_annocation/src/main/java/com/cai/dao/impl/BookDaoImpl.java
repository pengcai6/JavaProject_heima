package com.cai.dao.impl;

import com.cai.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dao1")
//@Scope()
public class BookDaoImpl implements BookDao {
    @Override
    public void update() {
        System.out.println("bookDao...");
    }
    @PostConstruct
    public void init(){
        System.out.println("init....");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory.....");
    }

}
