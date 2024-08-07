package com.itheima;

import com.itheima.Config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppForSpringMybatis {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService bean = context.getBean(AccountService.class);
        List<Account> all = bean.findAll();
        for (Account account : all) {
            System.out.println("account = " + account);
        }


    }
}
