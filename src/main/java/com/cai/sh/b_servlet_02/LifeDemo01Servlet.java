package com.cai.sh.b_servlet_02;

import javax.servlet.*;
import java.io.IOException;

/*
TODO:Servelt生命周期
 */

public class LifeDemo01Servlet implements Servlet {
    public LifeDemo01Servlet() {
        System.out.println("无参构造方法执行了");
    }
    //初始化方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service....");

    }

    @Override
    public String getServletInfo() {
        return "";
    }
    //销毁方法
    @Override
    public void destroy() {
        System.out.println("destroy....");

    }
}
