package com.cai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User控制器
 * 1.交给spring管理
 * 2.定义请求的处理方法
 * 3.设置当前方法的访问路径
 * 4.设置返回类型为spring
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("users")

public class UserController {
    //增加
    @PostMapping
    public String save() {
        return "save";
    }

    //删除
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        return "delete";
    }
        //修改
//    @RequestMapping( method = RequestMethod.PUT)
    @PutMapping
    public String update() {
        return "update";
    }
    //查询全部
 @GetMapping
    public String getAll(){
        return "getAll";
    }
    //根据id查询
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
@GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id){
        return "getById";
    }

}
