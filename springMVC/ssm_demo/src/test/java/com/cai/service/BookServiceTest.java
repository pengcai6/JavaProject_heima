package com.cai.service;

import com.cai.config.SpringConfig;
import com.cai.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println("all = " + all);
    }
    @Test
    public void testGetById(){
        Book byId = bookService.getById(2);
        System.out.println("byId = " + byId);
    }
    @Test
    public void save(){
        Book book = new Book();
        book.setName("123");
        book.setDescription("456");
        book.setType("456");
        boolean byId = bookService.save(book);
        System.out.println("byId = " + byId);
    }


}
