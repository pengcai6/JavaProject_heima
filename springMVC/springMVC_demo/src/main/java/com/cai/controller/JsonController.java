package com.cai.controller;

import com.cai.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;


@Controller
public class JsonController {
    /**
     * pojo类型的JSON
     * @param user
     * @return
     */
    @RequestMapping("pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user) {
        System.out.println("user = " + user);
        return "pojoParamForJson";
    }

    @RequestMapping("arrayParamForJson")
    @ResponseBody
    public String arrayParamForJson(@RequestBody String[] list) {
        System.out.println("list = " + Arrays.toString(list));
        return "arrayParamForJson";
    }



    @RequestMapping("PojoArrayParamForJson")
    @ResponseBody
    public String PojoArrayParamForJson(@RequestBody List<User> list) {
        System.out.println("list = " + list);
        return "PojoArrayParamForJson";
    }

}
