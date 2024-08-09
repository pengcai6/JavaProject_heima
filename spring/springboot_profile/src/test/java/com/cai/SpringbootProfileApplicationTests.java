package com.cai;

import com.cai.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//当路径不一致时可以指定配置类
@SpringBootTest(classes = SpringbootProfileApplication.class)
class SpringbootProfileApplicationTests {
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        bookService.save();
    }

}
