package com.cai.c_session_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo05Servlet")
public class SessionDemo05Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*
   * TODO:session原理验证
   * */
        //1.获取session
        HttpSession session = request.getSession();
        //2.获取session的唯一标识、
        String id = session.getId();
      //3.创建Cookie，将获取的JSESSIONID存储到Cookie中
        Cookie cookie = new Cookie("JSESSIONID",id);
        //4.持久化Cookie
        cookie.setMaxAge(60*60*24*7);
        //5.将Cookie响应给浏览器
        response.addCookie(cookie);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}