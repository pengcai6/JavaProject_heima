package com.cai.c_session_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo02Servlet")
public class SessionDemo02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.获取session
        HttpSession session = request.getSession();//有则获取，无则创建
        //2.从session中取出数据
        Object value = session.getAttribute("msg");//参数msg是方法session.setAttribute("msg","hello");的第一个参数
        //3.输出
        System.out.println("value = " + value);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}