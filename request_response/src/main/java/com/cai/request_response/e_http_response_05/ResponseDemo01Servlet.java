package com.cai.request_response.e_http_response_05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ResponseDemo01Servlet")
public class ResponseDemo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ResponseDemo01Servlet,我不行了");
//        response.setStatus(302);
//        response.setHeader("Location","/ResponseDemo02Servlet");
        //简写
        response.sendRedirect("/ResponseDemo02Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}