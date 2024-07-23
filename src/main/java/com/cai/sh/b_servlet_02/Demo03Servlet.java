package com.cai.sh.b_servlet_02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo03Servlet extends HttpServlet {
    //get请求执行的方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet实现方式三：自定义继承抽象类Servlet。。。get");
    }
    //post请求执行的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet实现方式三：自定义继承抽象类Servlet。。。post");

    }
}
