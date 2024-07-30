package com.cai.a_response_01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/ResponseDemo02Servlet")
public class ResponseDemo02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //TODO:向浏览器输出字节数据，使用的对象是response的方法
    //需求，输出本地的图片
    //1.创建字节输入流关联数据源文件
        FileInputStream fileInputStream = new FileInputStream("E:\\Users\\26068\\Desktop\\JavaProject\\day17_response\\src\\main\\resources\\1.jpg");
    //2.根据response对象调用方法获取关联浏览器的字节输出流对象
        ServletOutputStream outputStream = response.getOutputStream();

        //3.将数据源文件读取到内存中
        byte [] bytes=new byte[1024];//保存每次读写的数据
        int len=0;//记录每次读写字节的个数
        while((len=fileInputStream.read(bytes))!=-1) {
            //4.将内存中的数据写到浏览器中
            outputStream.write(bytes,0,len);
        }
    //5.释放资源
fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}