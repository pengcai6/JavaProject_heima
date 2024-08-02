package com.itheima.case2.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//TODO:不需要被访问不加路径
//@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求路径
        String URI = request.getRequestURI();
        //2.获取URI的最后一个/的索引
        int lastIndex = URI.lastIndexOf("/");
        //3.根据上述索引位置截取到最后末尾为止
        String methodName = URI.substring(lastIndex + 1);
        try {
            //TODO:  使用反射执行上述过多if语句问题
            //4.获取当前类的class对象
            //TODO: this当前类的对象
            Class<?> Clazz = this.getClass();
            //5.获取要执行的方法
            Method m = Clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //6.执行方法
            m.invoke(this,request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}