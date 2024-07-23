package com.cai.sh.a_servlet_01;

import javax.servlet.*;
import java.io.IOException;

//3.在创建的web项目中自定义类实现Servlet接口
public class HelloWorldServlet implements Servlet {
//4.在自定义类中实现Servlet接口中的所有的抽象方法 ctrl+i

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    //5.在实现Servlet接口的service方法体中书写代码处理业务逻辑
        System.out.println("servlet入门案例");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
