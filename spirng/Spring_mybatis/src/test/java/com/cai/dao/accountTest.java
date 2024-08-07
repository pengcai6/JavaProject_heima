package com.cai.dao;

import com.cai.Config.SpringConfig;
import com.cai.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * cai测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)//junit专用的类加载器
@ContextConfiguration(classes = SpringConfig.class)
public class accountTest {
    @Autowired
private AccountDao accountDao;
    @Test
    public void test(){
        Account byId = accountDao.findById(1);
        System.out.println("byId = " + byId);
    }
}
