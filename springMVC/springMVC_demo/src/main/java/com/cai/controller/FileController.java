package com.cai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("FileParam")
    @ResponseBody
    public String FileParam(MultipartFile File) throws IOException {

        if(!File.isEmpty()){
            //自定义文件
            File file1 = new File("E://test.txt");
            File.transferTo(file1);
        }
        return "FileParam";
    }
}
