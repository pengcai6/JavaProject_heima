package com.cai.json;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class JsonTest {
    /*
    需求：将java的对象转换为json字符串
     */
    //1.将实体类转为json对象
    @Test
    public void test1(){
    //1.创建User对象
        User user = new User();
        //2.添加数据
        user.setUsername("张三");
        user.setPassword("123");
        /*
        3.使用fastJson的核心类Json调用
         public static final String toJSONString(Object object);
            将任意对象转换为json字符串
         */
        String jsonString = JSON.toJSONString(user);
        //{"password":"123","username":"张三"}
        System.out.println(jsonString);

    }

    //2.将单列集合转为json对象
    @Test
    public void test2() {
    //1.创建集合对象
        ArrayList<User> arrayList = new ArrayList<User>();
        //2.添加数据
        Collections.addAll(arrayList,new User("456","789"),new User("741","852"));
        //3.使用fastJson将集合转为Json字符串
        String jsonString = JSON.toJSONString(arrayList);
        //jsonString = [{"password":"789","username":"456"},{"password":"852","username":"741"}]
        System.out.println("jsonString = " + jsonString);
    }
    //3.将双列集合转为json对象
    @Test
    public void test3() {
        HashMap<String, Object> Map = new HashMap<>();
        Map.put("123","刘燕");
        Map.put("456",new User("456","789"));
        ArrayList<User> arrayList = new ArrayList<User>();
        //2.添加数据
        Collections.addAll(arrayList,new User("456","789"),new User("741","852"));
        Map.put("789",arrayList);
        String jsonString = JSON.toJSONString(Map);
        /*
        jsonString = {"123":"刘燕",
        "456":{"password":"789","username":"456"},
        "789":[{"password":"789","username":"456"},{"password":"852","username":"741"}]}

         */
        System.out.println("jsonString = " + jsonString);
    }
}
