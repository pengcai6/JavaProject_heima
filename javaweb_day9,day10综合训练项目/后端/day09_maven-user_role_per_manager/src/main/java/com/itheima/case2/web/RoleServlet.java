package com.itheima.case2.web;

import com.itheima.case2.pojo.po.Role;
import com.itheima.case2.pojo.vo.Result;
import com.itheima.case2.service.roleService;
import com.itheima.case2.utils.BaseController;
import com.itheima.case2.utils.BeansFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/role/*")
public class RoleServlet extends BaseServlet {
    //定义用户下拉框中显示角色的方法
    public void findAllRose(HttpServletRequest request, HttpServletResponse response){

        try {
//1.获取业务层对象
            roleService roleService = BeansFactory.newInstance("roleService");
            //2.使用业务层对象调用查询角色方法
            List<Role> list= roleService.findAllRose();
            //3.将List封装到result类中
            Result result = new Result(true, "查询成功", list);
            //4.使用工具类响应给前端
            BaseController.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //3.将List封装到result类中
                Result result = new Result(false, "查询失败");
                //4.使用工具类响应给前端
                BaseController.printResult(response,result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



    }
}