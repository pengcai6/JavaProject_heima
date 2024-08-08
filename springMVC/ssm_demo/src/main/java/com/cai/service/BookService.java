package com.cai.service;

import com.cai.pojo.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {
    //新增
    boolean save(Book book);
    //查询全部
    List<Book> getAll();
    //根据id查询
    Book getById(Integer id);
    //更新
    boolean update(Book book);
    //根据id删除
    boolean delete(Integer id);
}
