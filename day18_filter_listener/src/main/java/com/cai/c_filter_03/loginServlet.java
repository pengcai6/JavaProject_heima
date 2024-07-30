package com.cai.c_filter_03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //2.创建User对象
        User user = new User();
        //3.封装数据
        user.setName(name);
        user.setPassword(password);
        //4.假设为正确的，将User添加到Session
      request.getSession().setAttribute("u",user);
      //4.1 持久化session
        String id = request.getSession().getId();
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
        //5.跳转到hack.html
        response.sendRedirect("/hack.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}