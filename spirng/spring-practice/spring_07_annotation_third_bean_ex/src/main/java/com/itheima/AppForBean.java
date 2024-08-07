package com.itheima;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.itheima")
//@Import(JdbcConfig.class)
public class AppForBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppForBean.class);
        DataSource bean = (DataSource) context.getBean("dateSource");
        System.out.println("bean = " + bean);
    }
}
