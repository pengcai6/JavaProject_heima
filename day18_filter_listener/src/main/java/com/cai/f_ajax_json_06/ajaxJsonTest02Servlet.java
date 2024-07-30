package com.cai.f_ajax_json_06;

import com.alibaba.fastjson.JSON;
import com.cai.c_filter_03.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajaxJsonTest02Servlet")
public class ajaxJsonTest02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2.请求是普通字符串，响应数据改成json字符串

        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.输出
        System.out.println(username+"-----"+password);
        //3.创建User对象
        User user = new User();
        //4.将接受数据封装到User对象中
        user.setName(username);
        user.setPassword(password);
        //5.使用fastJson转为Json
        String jsonString = JSON.toJSONString(user);
        //6.响应数据

        response.getWriter().print(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}