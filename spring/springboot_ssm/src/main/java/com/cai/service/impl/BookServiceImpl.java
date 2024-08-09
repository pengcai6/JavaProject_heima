package com.cai.service.impl;

import com.cai.dao.BookDao;
import com.cai.exception.BusinessException;
import com.cai.pojo.Book;
import com.cai.service.BookService;
import com.cai.vo.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        Integer save = bookDao.save(book);
        return save>0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id);
    }
}
