package com.cai.e_listener_05;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//1. 创建一个普通类，实现ServletContextListenner
//3.注解配置监听器
@WebListener
public class MyServletContextListener implements ServletContextListener {
    //2. 重写方法
    //当上下文对象ServletContext创建就执行该方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext创建了");
    }
    //当上下文对象ServletContext销毁就执行该方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext销毁了");
    }
}
