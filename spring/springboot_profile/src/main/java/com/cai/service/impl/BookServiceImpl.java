package com.cai.service.impl;

import com.cai.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("hello service");
    }
}
