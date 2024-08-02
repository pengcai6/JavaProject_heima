package com.itheima.case2.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
/*
TODO:
    1. /user/* 表示目录匹配，在前端访问的路径以/user开始都会访问当前路径UserServlet
        前端访问后端的路径为：
        https://localhost:8080/user/fingAll 表示查询全部用户
        https://localhost:8080/user/updata 表示更新用户
        https://localhost:8080/user/add 表示添加用户
        需要获取请求路径的最后目录 findAll 表示查询全部用户
 */

//@WebServlet("/user/*")
public class User1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求路径
        String URI = request.getRequestURI();
        //2.获取URI的最后一个/的索引
        int lastIndex = URI.lastIndexOf("/");
        //3.根据上述索引位置截取到最后末尾为止
        String methodName = URI.substring(lastIndex + 1);
//        if("findAll".equals(methodName)){
//            //说明是查询所有用户功能
//            //System.out.println("查询所有用户");
//            findAll(request,response);
//        }
//        else if("add".equals(methodName)){
//            //说明是添加用户功能
//            //System.out.println("添加用户");
//            add(request,response);
//        }
//        else if("update".equals(methodName)){
//            //说明是更新用户功能
//            //System.out.println("更新用户");
//            update(request,response);
//        }
//        else if("delete".equals(methodName)){
//            //说明是删除用户功能
//            //System.out.println("删除用户");
//            delete(request,response);
//        }
        try {
            //TODO:  使用反射执行上述过多if语句问题
            //1.获取当前类的class对象
            //TODO: this当前类的对象
        /*
    getDeclaredMethod( String name,  Class<?>... parameterTypes )
    name :  方法名 delete add update
    parameterTypes:要执行方法的形参Class类型
         */
            Class<?> Clazz = this.getClass();
            //2.获取要执行的方法
            Method m = Clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.执行方法
            /*  Method中的方法：执行方法
             *  public Object invoke(Object obj, Object... args)
             * 参数：
             *      obj:要执行方法依赖的对象，delete方法依赖的对象是this
             *      args：要执行方法的实参
             *       返回值：Object 表示要执行方法的返回值，无则为null
             */
            m.invoke(this,request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除用户");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("更新用户");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加用户");
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("查询所有用户");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}