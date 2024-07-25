package com.cai.web;

import com.cai.pojo.Role;
import com.cai.pojo.User;
import com.cai.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {
    @Test
    void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.queryUserByPage(1, 3);
        for (User user : userList) {
            System.out.println("用户信息:"+user);
            List<Role> roles=user.getRoles();
            for (Role role : roles) {
                System.out.println("角色信息:"+role);
            }
        }
    }

    @Test
    void test2(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUserById(3);
    }
    @Test
    void test3(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.update(8);
    }
}
