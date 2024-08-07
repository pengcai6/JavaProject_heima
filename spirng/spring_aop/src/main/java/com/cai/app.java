package com.cai;

import com.cai.config.springConfig;
import com.cai.dao.UserMapper;
import com.cai.service.ResourceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        //创建Ioc容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(springConfig.class);
        //容器中获取bean
//        UserMapper bean = ctx.getBean(UserMapper.class);
//        Integer save = bean.save("cai");
//        System.out.println("save = " + save);
        ResourceService bean = ctx.getBean(ResourceService.class);
        bean.saveUrl("456   ","   456");
    }
}
