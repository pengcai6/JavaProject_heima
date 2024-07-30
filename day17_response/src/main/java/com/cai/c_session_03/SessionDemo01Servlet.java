package com.cai.c_session_03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/sessionDemo01Servlet")
public class SessionDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.创建session
        HttpSession session = request.getSession();//有则获取，无则创建
        session.setAttribute("msg","hello");//设置数据
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}