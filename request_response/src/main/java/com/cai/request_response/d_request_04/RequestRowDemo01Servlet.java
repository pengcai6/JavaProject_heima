package com.cai.request_response.d_request_04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/requestRowDemo01Servlet")
public class RequestRowDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        对于这三部分内容，request对象都提供了对应的API方法来获取，具体如下:
//
//* 获取请求方式: `GET`
//
//```
//        String getMethod()
        System.out.println(request.getMethod());
//```
//
//* 获取虚拟目录(项目访问路径): `/request-demo`
//
//```
//        String getContextPath()
//```
        System.out.println(request.getContextPath());
//
//* 获取URL(统一资源定位符): `http://localhost:8080/request-demo/req1`
//
//```
//        StringBuffer getRequestURL()
        StringBuffer requestURL = request.getRequestURL();
        String requestURLString = requestURL.toString();
        System.out.println(requestURLString);
//```
//
//* 获取URI(统一资源标识符): `/request-demo/req1`
//
//```
//        String getRequestURI()
        System.out.println(request.getRequestURI());
//```
//
//* 获取请求参数(GET方式): `username=zhangsan&password=123`
//
//```
//        String getQueryString()
//```
        System.out.println(request.getQueryString());
//

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}