package com.itheima.case2.web;

import com.itheima.case2.pojo.vo.*;
import com.itheima.case2.service.UserService;
import com.itheima.case2.utils.BaseController;
import com.itheima.case2.utils.BeansFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
        TODO:
            以后在创建Servlet只需要继承BaseServlet，而BaseServlet继承了HttpServlet，因此
            UserServlet属于HttpServlet
            只需要写功能就行了
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("删除用户");
        try {
            //1.获取请求参数
            Integer id = BaseController.parseJSON2Object(request, Integer.class);
            //2.创建业务层对象
            UserService userService = BeansFactory.newInstance("userService");
            //3.使用业务层对象调用方法
            userService.delete(id);
            //4.创建结果对象
            Result result = new Result(true, "删除用户成功");
            //5.将结果响应给前端
            BaseController.printResult(response,result);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                //4.创建结果对象
                Result result = new Result(false, "删除用户失败");
                //5.将结果响应给前端
                BaseController.printResult(response,result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    //修改用户
    public void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1.获取请求参数
            UpdateUser updateUser = BaseController.parseJSON2Object(request, UpdateUser.class);
            //2.创建业务层对象
            UserService userService = BeansFactory.newInstance("userService");
            //3.使用业务层对象调用方法
            userService.update(updateUser);
            //4.创建结果对象
            Result result = new Result(true, "更新用户成功");
            //5.将结果响应给前端
            BaseController.printResult(response,result);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                //4.创建结果对象
                Result result = new Result(false, "更新用户失败");
                //5.将结果响应给前端
                BaseController.printResult(response,result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        }

    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("添加用户");
        try {
            //1.将前端请求的数据封装到实体类AddUser中
            AddUser addUser = BaseController.parseJSON2Object(request, AddUser.class);
            //2.创建业务层对象
            UserService userService = BeansFactory.newInstance("userService");
            //3.调用业务层中的add方法
            userService.add(addUser);
            //4.创建结果对象
            Result result = new Result(true, "添加用户信息成功");
            //5.将结果响应给前端
            BaseController.printResult(response,result);

        } catch (Exception e) {
            try {
                //4.创建结果对象
                Result result = new Result(false, "添加用户信息失败");
                //5.将结果响应给前端
                BaseController.printResult(response,result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("查询所有用户");
        try {
            //1.将前端请求的页码的每页条数封装到实体类QueryPageBean
            QueryPageBean pb = BaseController.parseJSON2Object(request, QueryPageBean.class);
            //2.创建业务层对象
            //实现左边解耦合，如果扩展只需要修改等号右边
//            UserService userService = new UserServiceImpl();
//            //使用反射+读取配置文件创建对象
//            ResourceBundle bundle = ResourceBundle.getBundle("beans");//不能书写文件后缀名
//            //根据配置文件的key获取值
//            String classNameStr = bundle.getString("userService");
//            //使用反射创建对象
//            Class<?> Clazz = Class.forName(classNameStr);
//            UserService userService = (UserService) Clazz.newInstance();//调用无参构造方法
            //TODO:从springIOC的工厂中获取UserServiceImpl类的对象
            UserService userService = BeansFactory.newInstance("userService");

            //3.使用对象调用方法
            PageResult pageResult=  userService.findAll(pb);
            //4.创建Result对象
            Result result = new Result(true, "查询用户成功",pageResult);
            //5.将result转化为JSON响应给前端
            BaseController.printResult(response, result);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //4.创建Result对象
                Result result = new Result(false, "查询用户失败");
                //5.将result转化为JSON响应给前端
                BaseController.printResult(response, result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }


}