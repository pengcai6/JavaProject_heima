package com.cai.f_ajax_json_06;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {
    //静态方法解析前端提交的JSON格式的数据
//    public static Object parseJsonToObject(HttpServletRequest request, Class clazz)throws Exception
//    {
//        Object object = JSON.parseObject(request.getInputStream(), clazz);
//        return object;
//    }
    //使用泛型进行优化
        public static <T> T parseJsonToObject(HttpServletRequest request, Class<T> clazz)throws Exception
    {
        T object = JSON.parseObject(request.getInputStream(), clazz);
        return object;
    }

    //静态方法将后端的JSON数据响应给前端
    public static void responseJsonToBrowser(HttpServletResponse response,Object object) throws IOException {

        //5.将result对象转为JSON
        String jsonString = JSON.toJSONString(object);
        //6.响应数据
        response.getWriter().print(jsonString);

    }
}
