package com.cai.controller;

import com.cai.config.enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/books")
public class BookController {
    @Value("${enterprise.name}")
    private String name;
    @Value("${enterprise.subjects[1]}")
    private String obj;
    @Autowired
    private enterprise enterprise;
@RequestMapping("/save")
public String save(){
//    System.out.println("name = " + name);
//    System.out.println("obj = " + obj);
    System.out.println("enterprise = " + enterprise);
    return "helle,Springboot";
}

}
