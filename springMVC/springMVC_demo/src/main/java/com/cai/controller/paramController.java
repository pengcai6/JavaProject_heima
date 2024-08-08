package com.cai.controller;

import com.cai.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class paramController {
    /**
     * 普通参数传递
     * @return
     */
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(@RequestParam("name") String username, Integer age){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "commonParam";
    }
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("user = " + user);
        return "pojoParam";
    }
    @RequestMapping("/pojoContainParam")
    @ResponseBody
    public String pojoContainParam(User user){
        System.out.println("user = " + user);
        return "pojoContainParam";
    }
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("likes = " + Arrays.toString(likes));
        return "arrayParam";
    }
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> list){
        System.out.println("list = " + list);
        return "listParam";
    }
    @RequestMapping("/mapParam")
    @ResponseBody
    public String listParam(@RequestParam Map<String,String> map){
        System.out.println("map = " + map);
        return "mapParam";
    }


}
