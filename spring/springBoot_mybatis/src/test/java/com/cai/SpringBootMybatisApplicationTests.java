package com.cai;

import com.cai.dao.BookDao;
import com.cai.po.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        List<Book> all = bookDao.getAll();
        System.out.println("all = " + all);
    }

}
