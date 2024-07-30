package com.cai.c_filter_03;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
解决全站乱码问题
* */


@WebFilter("/*")//拦截全部资源
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) req;
        javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) resp;
        //your code
        //处理请求乱码
        request.setCharacterEncoding("utf-8");
        //处理响应乱码
        response.setContentType("/text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}