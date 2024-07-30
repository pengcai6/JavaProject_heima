package com.cai.a_filter_01;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
TODO:
过滤器的过滤资源路径
1.精确匹配 /demo03.html 这里必须加/
2.目录匹配： /xx/*  只要浏览器访问的路径以xx开始就会执行当前过滤器
3.后缀名匹配：*.xx  只要浏览器访问的路径以xx结尾就会执行当前过滤器，注意：这里不能加/
4.拦截所有： /*  只要浏览器访问当前项目就会执行当前过滤器 *************
注意：在过滤器中，如果多个过滤器过滤器同一个资源，那么要执行所有的满足条件的过滤器
*/

//@WebFilter("*.html")
public class PathDemo02Servlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) req;
        javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) resp;
        //your code
        System.out.println("路径匹配。。。。");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}