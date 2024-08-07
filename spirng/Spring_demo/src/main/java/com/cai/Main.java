package com.cai;

import com.cai.Service.BookService;
import com.cai.Service.impl.BookServiceImpl;
import com.cai.dao.BookDao;
import com.cai.dao.impl.BookDaoImpl;

public class Main {
    public static void main(String[] args) {
//        new BookDaoImpl().save();
        BookDao bookDao=new BookDaoImpl();
        BookService bookService=new BookServiceImpl();
        bookService.setBookDao(bookDao);
        bookService.save();
    }
}
