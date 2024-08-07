package com.itheima;

import com.itheima.jdbc.ConnectionData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDi {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ConnectionData conn = (ConnectionData) context.getBean("ConnectionData");
        System.out.println(conn);
    }
}
