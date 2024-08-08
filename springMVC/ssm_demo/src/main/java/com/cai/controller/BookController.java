package com.cai.controller;

import com.cai.pojo.Book;
import com.cai.service.BookService;
import com.cai.vo.Code;
import com.cai.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * book控制器
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    //新增
    @PostMapping()
    Result save(@RequestBody Book book){
        boolean result = bookService.save(book);
        Integer code=result ? Code.SAVE_OK:Code.SAVE_ERR;
        String msg=result?"插入成功":"插入失败";
    return new Result(code,result,msg);
    }
    //查询全部
    @GetMapping
    Result getAll(){
        List<Book> bookList = bookService.getAll();
        Integer code=bookList!=null ? Code.SELECT_OK:Code.SELECT_ERR;
        String msg=bookList!=null?"查找成功":"查找失败";
        System.out.println("get all 执行 ");
        return new Result(code,bookList,msg);
    }
    //根据id查询
    @GetMapping("/{id}")
    Result getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        Integer code= book !=null ? Code.SELECT_OK:Code.SELECT_ERR;
        String msg= book !=null?"查找成功":"查找失败";
        return new Result(code, book,msg);
    }
    //更新
    @PutMapping()
   Result update(@RequestBody Book book){
        boolean result = bookService.update(book);
        Integer code=result ? Code.UPDATE_OK:Code.UPDATE_ERR;
        String msg=result?"更新成功":"更新失败";
        return new Result(code,result,msg);
    }
    //根据id删除
    @PutMapping("/{id}")
    Result delete(@PathVariable Integer id){
        boolean result = bookService.delete(id);
        Integer code= result ? Code.DELETE_OK:Code.DELETE_ERR;
        String msg= result ?"删除成功":"删除失败";
        return new Result(code, result,msg);
    }
}
