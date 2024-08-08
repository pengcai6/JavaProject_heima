package com.cai.controller;

import com.cai.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class responseController {
    //返回页面
@RequestMapping("toPage")
public String toPage(){
    System.out.println("toPage");
    return "pages.jsp";
}
//返回文本
@RequestMapping("toText")
@ResponseBody
public String toText(){
    System.out.println("toText");
    return "pages.jsp";
}


@RequestMapping("toJson")
@ResponseBody
public User toJson(){

    User user = new User();
    user.setName("libo");
    user.setAge(16);
    return user;
}

@RequestMapping("toJsonArray")
@ResponseBody
public List<User> toJsonArray(){
    List<User>list=new ArrayList<User>();
    User user = new User();
    user.setName("libo");
    user.setAge(16);
    list.add(user);
    list.add(user);
    return list;
}
}
