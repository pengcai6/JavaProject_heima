package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForIoc {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=new User();
        user.setId(100L);
        user.setUserName("Spring小能手");
        user.setAge(21);

        UserDao userDao = (UserDao) context.getBean("User");
        userDao.save(user);
    }
}
