package com.cai.b_cookie_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo02Servlet")
public class CookieDemo02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
    获取浏览器请求的Cookie
        */
    //1.取出请求中的Cookie
        Cookie[] cookies = request.getCookies();
    //2.遍历数组
        for (Cookie cookie : cookies) {
            //3.获取Cookie的name’
            String name = cookie.getName();
            //4.获取Cookie的value
            String value = cookie.getValue();
            System.out.print("name ----" + name);
            System.out.println("value ---- " + value);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}