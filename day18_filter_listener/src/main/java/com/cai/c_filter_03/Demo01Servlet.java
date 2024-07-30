package com.cai.c_filter_03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取请求参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        //2.响应给浏览器
        response.getWriter().write("蔡");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}