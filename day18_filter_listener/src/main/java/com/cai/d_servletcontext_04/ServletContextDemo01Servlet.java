package com.cai.d_servletcontext_04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ServletContextDemo01Servlet")
public class ServletContextDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
    * ServletContext*/
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("1.jpg");
        System.out.println("mimeType = " + mimeType);
        String realPath = servletContext.getRealPath("1.jpg");
        System.out.println("realPath = " + realPath);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}