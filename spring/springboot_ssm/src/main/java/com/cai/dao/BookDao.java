package com.cai.dao;

import com.cai.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookDao {
    //插入操作
    @Insert("insert into tbl_book (TYPE, NAME, description) VALUES (#{type},#{name},#{description})")
    Integer save(Book book);
    //查询全部
    @Select("select * from tbl_book")
    List<Book>  getAll();
    //根据id查询
    @Select("select *from tbl_book where id=#{id}")
    Book getById(@Param("id") Integer id);
    //更新
    @Update("update tbl_book set description=#{description},NAME=#{name},TYPE=#{type} where id=#{id} ")
    boolean update(Book book);

    //根据id删除
    @Delete("delete from tbl_book where id=#{id}")
    boolean delete(@Param("id") Integer id);
}
