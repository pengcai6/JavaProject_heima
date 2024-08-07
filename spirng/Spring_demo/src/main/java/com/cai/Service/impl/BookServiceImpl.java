package com.cai.Service.impl;

import com.cai.Service.BookService;
import com.cai.dao.BookDao;
import com.cai.dao.impl.BookDaoImpl;

public class BookServiceImpl implements BookService {
    BookDao bookDao;
    @Override
    public void save() {
        bookDao.save();
        System.out.println("bookService.... ");
    }
    public void setBookDao(BookDao bookDao)
    {
        this.bookDao=bookDao;
    }
}
