package com.cai.dao;

import com.cai.po.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * book数据接口层
 */
@Mapper
public interface BookDao {
@Select("select *from tbl_book")
List<Book> getAll();
}
