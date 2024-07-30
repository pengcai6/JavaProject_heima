package com.cai.b_filter_02;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/apple")
public class Afilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) req;
        javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) resp;
        //your code
        System.out.println("Afilter执行前");
        chain.doFilter(request, response);
        System.out.println("Afilter执行后");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}