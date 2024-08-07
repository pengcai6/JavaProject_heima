package com.cai;

import com.cai.Config.SpringConfig;

import com.cai.dao.AccountDao;
import com.cai.pojo.Account;
import com.cai.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
//        AccountDao AccountDao = ctx.getBean(AccountDao.class);
////        Account byId = AccountDao.findById(2);
//        System.out.println("byId = " + byId);
//        AccountDao.inMoney("Tom",100d);
        TransferService service = ctx.getBean(TransferService.class);
        service.Transfer("Tom","Jerry",100d);
    }
}
