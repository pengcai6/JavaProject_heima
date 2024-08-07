package com.cai.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdviceForResource {
    //对谁做增强
    //定义切入点
    @Pointcut("execution(* com.cai.service.ResourceService.saveUrl(..))")
    public void pt(){

    }

     @Around("pt()")
     public Object around(ProceedingJoinPoint JoinPoint) throws Throwable {
         Object[] args = JoinPoint.getArgs();
         for (int i=0;i<args.length;i++) {
           if(args[i].getClass().equals(String.class))
           {
              args[i]= args[i].toString().trim();
           }
         }

         Object proceed = JoinPoint.proceed(args);
         return proceed;
    }



}
