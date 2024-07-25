package com.cai.request_response.d_request_04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/requestDemo06")
public class requestDemo06 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.第一种方法
 //       request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
    //    System.out.println("username = " + username);

        //2.第二种方法
//        username= URLEncoder.encode(username, "ISO-8859-1");
//         username=URLDecoder.decode(username,"UTF-8");

        //3.第三种方法
        byte[] bytes = username.getBytes("ISO-8859-1");
         username = new String(bytes, "UTF-8");
        System.out.println("username = " + username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}