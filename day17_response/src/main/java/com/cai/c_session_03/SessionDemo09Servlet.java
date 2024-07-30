package com.cai.c_session_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo09Servlet")
public class SessionDemo09Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  /*
  Session的销毁
  1.默认存活时间为30分钟
2.通过HttpSession中的invalidate()进行销毁
*/
        //1.创建session
        HttpSession session = request.getSession();
        //2.输出id
        System.out.println(session.getId());
        //3.销毁
        session.invalidate();
        //4.向session中存储数据‘
        session.setAttribute("msg","你好");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}