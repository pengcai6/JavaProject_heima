package com.cai.request_response.d_request_04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/requestDemo04Servlet")
public class RequestDemo04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*    需求：获取请求参数（Get,Post）*/

        //1.获取请求方式
        String method = request.getMethod();
        //2.判断请求方式
        if("GET".equals(method)){
            System.out.println("获取的Get请求的请求参数"+request.getQueryString());
        }else if("POST".equals(method)){
            BufferedReader reader = request.getReader();
            String line=null;
            while ((line=reader.readLine())!=null)
            {
                System.out.println("获取的Post的请求参数"+line);
            }
        }else {
            throw new RuntimeException();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}