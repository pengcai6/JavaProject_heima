package com.cai.a_filter_01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/demo01.html")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //不要调用父的方法否则报错
        //Filter.super.init(filterConfig);
    }
    //3.在doFilter方法体中书写拦截资源的代码
    //每次访问被过滤的资源都要执行该方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter......");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
