package com.cai;

import com.cai.Service.BookService;
import com.cai.Service.ResourceService;
import com.cai.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //初始化容器
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("springContext.xml");
        BookDao bookdao = (BookDao) ctx.getBean("bookdao");

//        System.out.println(bookdao);
//        BookDao bookdao2 = (BookDao) ctx.getBean("dao2");
//        System.out.println(bookdao2);
                bookdao.save();
        ctx.close();
//        BookService bookService = (BookService) ctx.getBean("bookService");
//        bookService.save();
//        ResourceService resourceService = (ResourceService) ctx.getBean("ResourceService");
//        System.out.println(resourceService);

    }
}
