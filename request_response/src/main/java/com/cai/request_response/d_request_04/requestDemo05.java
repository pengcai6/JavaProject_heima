package com.cai.request_response.d_request_04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/requestDemo05")
public class requestDemo05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*获取请求参数的通用方式*/
        /*1.Map<String,String[]> getParameterMap()获取所有的请求参数*/
        Map<String, String[]> parameterMap = request.getParameterMap();
//        for (String key : parameterMap.keySet()) {
//            System.out.println(key+":");
//            String[] values = parameterMap.get(key);
//            for (String value : values) {
//                System.out.print(value+" ");
//            }
//        }
        //jdk8遍历map
        parameterMap.forEach((key,value)->{
            System.out.println(key+"---"+ Arrays.toString(value));
        });
//2.根据名称获取参数值（数组）
        String[] values = request.getParameterValues("username");
        System.out.println(Arrays.toString(values));
//3.根据名称获取参数值(单个值)
        String username = request.getParameter("username");
        System.out.println("username = " + username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}