package com.itheima.sh.web;

import com.itheima.sh.pojo.User;
import com.itheima.sh.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解决post乱码问题
        request.setCharacterEncoding("UTF-8");
        //2.接收前端提交的请求参数
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        //3.将请求参数封装到User实体类中 ===>User
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        //4.创建业务层即service层对象
        UserServiceImpl userService = new UserServiceImpl();
        //5.使用业务层对象调用业务层的登陆方法将user对象传递到业务层
        Boolean result= userService.register(user);
        //6.将返回值给前端服务器
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}