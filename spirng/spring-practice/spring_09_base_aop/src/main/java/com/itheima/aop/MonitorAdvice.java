package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//通知类必须配置成Spring管理的bean
@Component
@Aspect
public class MonitorAdvice {
    //1.创建切面

    @Pointcut("execution(public * com.itheima.service.impl.OrderServiceImpl.*(..))")
    private void pt(){}
    private static HashMap<String,Integer> map=new HashMap<>();
    private static int num = 1;
    @Before("pt()")
    public void monitor(JoinPoint jp){
        Signature signature = jp.getSignature();
        String typeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        map.putIfAbsent(typeName+"."+name,1);
        Integer i = map.get(typeName + "." + name);
        map.replace(typeName + "." + name,i+1);
        System.out.println(typeName + "." + name+"的调用次数"+ i);
        System.out.println("订单模块被调用："+ num++ + "次");
    }

}
