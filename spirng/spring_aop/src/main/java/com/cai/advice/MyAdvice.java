package com.cai.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Timer;
@Component
@Aspect
public class MyAdvice {
    //对谁做增强
    @Pointcut("execution(* com.cai.dao.UserMapper.save(*))")
    public void pt(){

    }
    //什么时候增强，增强哪些内容
     @Before("pt()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("before");
    }
    //后置通知
  //  @After("pt()")
    public void after(){
        long timeMillis = System.currentTimeMillis();
        System.out.println("after");
    }
   // @Around("pt()")
     public Object around(ProceedingJoinPoint JoinPoint) throws Throwable {
        //获取签名
        Signature signature = JoinPoint.getSignature();
        //获取接口名称
        String typeName = signature.getDeclaringTypeName();
      //  System.out.println("typeName = " + typeName);
        //获取方法名称
        String name = signature.getName();
    //    System.out.println("name = " + name);
        System.out.println("around before");
        Integer proceed=null;
        //获取开始时间
        long start = System.currentTimeMillis();
        //执行被代理的方法
        for(int i=0;i<10000;i++){//执行一万次
            proceed  = (Integer) JoinPoint.proceed();
        }
        //获取结束时间
        long end=System.currentTimeMillis();
        long time=end-start;
        System.out.println("执行一万次以后的时间 "+typeName+name+"===>" + time+"ms");
        System.out.println("around after");
        return proceed;
    }

    @AfterReturning(value = "pt()",returning ="num")
    public void AfterReturning(Integer num) {
        System.out.println("num = " + num);
        System.out.println("AfterReturning");

    }

    @AfterThrowing( value = "pt() ",throwing = "throwable")
    public void AfterThrowing(Throwable throwable) {

        System.out.println("AfterThrowing:"+throwable);

    }



}
