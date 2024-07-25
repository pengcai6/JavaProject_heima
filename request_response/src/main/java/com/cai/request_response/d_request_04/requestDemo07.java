package com.cai.request_response.d_request_04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/requestDemo07")
public class requestDemo07 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request请求转发
        System.out.println("requestDemo07......");
        request.setAttribute("msg","用户名或者密错误");
        //获取转发器
        RequestDispatcher dispatcher = request.getRequestDispatcher("/requestDemo08");
        //跳转
        //链式编程 request.getRequestDispatcher("/requestDemo08").forward(request,response)
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}