package com.cai.b_cookie_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet("/cookieDemo04Servlet")
public class CookieDemo04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
    向Cookie存储特殊字符报错
        */
        String value="12 34";
        String encode = URLEncoder.encode(value, "utf-8");
        Cookie cookie = new Cookie("msg",encode);

        response.addCookie(cookie);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}