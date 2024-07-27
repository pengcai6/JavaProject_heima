package com.itheima.sh.web;

import com.itheima.sh.pojo.User;
import com.itheima.sh.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

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
        User u=userService.login(user);
        //6.判断u是否为null
        if(u==null){
        //7.如果u==null,说明没有查询到数据，登陆失败，响应给前端一个false
        response.getWriter().print(false);
        }
        else{
        //8.如果u不等于null,说明查询到用户了，响应给前端一个true
        response.getWriter().print(true);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}