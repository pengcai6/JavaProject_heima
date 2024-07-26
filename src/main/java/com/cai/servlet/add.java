package com.cai.servlet;

import com.cai.dao.dishMapper;
import com.cai.pojo.dish;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static com.cai.util.mybatisUtil.getSession;

@WebServlet("/add")
public class add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        dish dish = new dish();

        // 获取 name 参数
        String name = request.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            dish.setName(name);
        }

        // 获取 Price 参数
        String priceStr = request.getParameter("price");
        if (priceStr != null && !priceStr.trim().isEmpty()) {
            try {
                double price = Double.parseDouble(priceStr);
                dish.setPrice(price);
            } catch (NumberFormatException e) {
                // 处理价格格式错误的情况，例如记录日志或向用户显示错误消息
                System.err.println("Error parsing price: " + e.getMessage());
            }
        }

        // 获取 description 参数
        String description = request.getParameter("description");
        if (description != null && !description.trim().isEmpty()) {
            dish.setDescription(description);
        }
        SqlSession sqlSession = getSession();
        dishMapper dishMapper = sqlSession.getMapper(dishMapper.class);
        int add = dishMapper.add(dish);
        if(add>0){
            sqlSession.commit();
            System.out.println("添加成功");
            sqlSession.close();
        }
        else {
            System.out.println("添加失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}