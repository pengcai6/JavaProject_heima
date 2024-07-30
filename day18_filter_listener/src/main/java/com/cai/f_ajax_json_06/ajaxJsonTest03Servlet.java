package com.cai.f_ajax_json_06;

import com.alibaba.fastjson.JSON;
import com.cai.c_filter_03.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/ajaxJsonTest03Servlet")
public class ajaxJsonTest03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2.请求是普通字符串，响应数据改成json字符串
        /*
        TODO:request.getParameter("表示符")
            只能获取请求参数是普通字符串数据，如果是Json数据该方法无效
            如果获取json的数据使用
            1）request.getInputStream() 读取关联浏览器的字节输入流
            2）request.getReader() 读取关联浏览器的字符输入流
            以后可以使用上述获取流的方法结合fastJson的方法一起使用解析前端提交的Json数据
            public static final <T> T parseObject(String text, Class<T> clazz);
                    参数：
                    is :关联浏览器的字节输入流
                    clazz:封装JSON请求参数的字节码对象
                    注意：要求实体类属性名必须和JSON的key一致
                      let params = " {\"name\":\"刘燕\",\"password\":\"123\"}";
                      User实体类的属性名必须是name和password
             */


        User user = JSON.parseObject(request.getInputStream(), User.class);
        System.out.println("user = " + user);
        //2.模拟从数据库中查询多个数据
        ArrayList<User> list = new ArrayList<>();
         //3.向list中添加数据
        Collections.addAll(list,user,new User("456","789"),new User("147","258"));
        //4.将集合list转化为JSON字符串
        String jsonString = JSON.toJSONString(list);
        //5.将数据响应给字符串
        response.getWriter().print(jsonString);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}