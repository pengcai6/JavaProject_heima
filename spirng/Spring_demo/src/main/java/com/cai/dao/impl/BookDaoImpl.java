package com.cai.dao.impl;

import com.cai.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookDaoImpl implements BookDao, InitializingBean, DisposableBean {
    @Override
    public void save() {
        System.out.println("BookDao....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init.....");
    }

//    public void init(){
//        System.out.println("init.....");
//    }
//    public void destory(){
//        System.out.println("destory....");
//    }
}
