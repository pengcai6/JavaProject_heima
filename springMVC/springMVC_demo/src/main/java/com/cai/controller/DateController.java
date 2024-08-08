package com.cai.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class DateController {
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2){
        System.out.println("date = " + date);
        System.out.println("date2 = " + date2);
        return "dateParam";
    }

}
