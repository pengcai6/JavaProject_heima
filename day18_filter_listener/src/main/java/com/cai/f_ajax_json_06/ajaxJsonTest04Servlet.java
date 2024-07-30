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

@WebServlet("/ajaxJsonTest04Servlet")
public class ajaxJsonTest04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //2.请求是普通字符串，响应数据改成json字符串
            //User user = JSON.parseObject(request.getInputStream(), User.class);
            User user = BaseController.parseJsonToObject(request, User.class);
            System.out.println("user = " + user);
            //2.模拟从数据库中查询多个数据
            ArrayList<User> list = new ArrayList<>();
            //3.向list中添加数据
            Collections.addAll(list,user,new User("456","789"),new User("147","258"));
            //4.创建result对象
            Result result = new Result(true,"查询成功",list);
            //5.将result对象转为JSON
           // String jsonString = JSON.toJSONString(result);
            //6.响应数据
           // response.getWriter().print(jsonString);
            BaseController.responseJsonToBrowser(response,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}