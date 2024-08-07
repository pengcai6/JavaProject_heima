package com.cai.Service;

import com.cai.dao.BookDao;

public interface BookService {
    void save();
    public void setBookDao(BookDao bookDao);
}
