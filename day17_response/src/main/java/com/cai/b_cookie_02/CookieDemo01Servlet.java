package com.cai.b_cookie_02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cookieDemo01Servlet")
public class CookieDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.创建Cookie对象，并且向其存储数据 Cookie(String name, String value)
        //name值是唯一的，如果value值相同，后出现的会覆盖之前的
        Cookie cookie = new Cookie("msg", "刘燕");
    //2.将Cookie响应给浏览器客户端
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}