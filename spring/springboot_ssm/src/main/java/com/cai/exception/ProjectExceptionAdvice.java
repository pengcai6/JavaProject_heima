package com.cai.exception;

import com.cai.vo.Code;
import com.cai.vo.Result;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(),e.getMessage());
    }


    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        return new Result(e.getCode(),e.getMessage());
    }


@ExceptionHandler(Exception.class)
    public Result doException(Exception e){
    return new Result(Code.ERROR,"项目出错了");
}
}
