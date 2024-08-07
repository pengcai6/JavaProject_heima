package com.cai.service.impl;

import com.cai.dao.BookDao;
import com.cai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Value("${name}")
    private String name;

    @Override
    public void update() {
        bookDao.update();
        System.out.println("bookService....");
        System.out.println(name+"hello");
    }
}
