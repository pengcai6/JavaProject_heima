package com.cai;

import com.cai.config.SpringConfig;
import com.cai.dao.BookDao;
import com.cai.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class app {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        //BookDao bookDao = ctx.getBean(BookDao.class);
//        BookDao bookDao = ctx.getBean("dao1",BookDao.class);
////        bookDao.update();
//        ctx.close();
//        BookServiceImpl bookServiceImpl = ctx.getBean(BookServiceImpl.class);
//        bookServiceImpl.update();
       // DataSource bean = ctx.getBean(DataSource.class);
        DataSource bean = (DataSource) ctx.getBean("dataSource");
        System.out.println("bean = " + bean);
    }
}
