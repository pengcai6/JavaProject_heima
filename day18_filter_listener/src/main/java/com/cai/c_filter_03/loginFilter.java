package com.cai.c_filter_03;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//当前过滤器过滤的是/hack.html
@WebFilter("/hack.html")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) req;
        javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) resp;
        //your code
        //1.从session中获取User对象
        User U = (User) request.getSession().getAttribute("u");
        //2.判断是否为null
        if(U==null){
            //说明没有登陆，跳转到登陆页面
            response.sendRedirect("/login.html");
        }else{
            //说明已经登陆，跳转到loginServlet
            chain.doFilter(request, response);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}