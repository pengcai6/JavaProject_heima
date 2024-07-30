package com.cai.a_filter_01;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/demo02.html")
public class LifeDemo01Filter implements Filter {
    public void destroy() {
        System.out.println("destroy...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) req;
        javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) resp;
        System.out.println("doFilter.....");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init......");
    }

}