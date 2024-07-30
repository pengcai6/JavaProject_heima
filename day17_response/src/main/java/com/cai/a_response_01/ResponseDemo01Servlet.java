package com.cai.a_response_01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ResponseDemo01Servlet")
public class ResponseDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //TODO:向浏览器输出字符数据，使用的对象是response的方法
        //1.获取响应字符数据的字符输出流
//        PrintWriter pw = response.getWriter();
//        //2.响应数据
//        pw.println("test");
        //处理响应中文乱码
        // response.setHeader("Content-Type","text/html;charset=utf-8");//数据为超文本，且码表为utf-8
        //使用简写
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你好");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}