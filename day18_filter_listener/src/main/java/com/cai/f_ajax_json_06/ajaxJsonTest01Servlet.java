package com.cai.f_ajax_json_06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ajaxJsonTest01Servlet")
public class ajaxJsonTest01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.输出
        System.out.println(username+"-----"+password);
        //3.响应数据
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("后端已经接受到了");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}