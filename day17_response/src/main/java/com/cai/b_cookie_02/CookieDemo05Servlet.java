package com.cai.b_cookie_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookieDemo05Servlet")
public class CookieDemo05Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
     向Cookie存储特殊字符报错
        */
        //1.获取Cookie
        Cookie[] cookies = request.getCookies();
        //2.遍历
        for (Cookie cookie : cookies) {
            //3.获取name
            String name = cookie.getName();
            //4.判断
            if("msg".equals(name)){
                //5.获取value
                String value = cookie.getValue();
                String decode = URLDecoder.decode(value, "utf-8");
                System.out.println("decode = " + decode);

            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}