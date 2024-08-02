package com.itheima.case2.utils;

import java.util.HashMap;
import java.util.ResourceBundle;

/*
TODO:当前工厂类的作用就是创建对象的
    一个类对象：
    单例 单个对象
    多例 多个对象
    在这里实现的是单例

 */
public class BeansFactory {
    private static HashMap<String,Object> map=new HashMap<>();
    public static synchronized  <T> T newInstance(String key)throws Exception
    {
        Object obj = map.get(key);
        if(obj==null)
        {
            //使用反射+读取配置文件创建对象
            ResourceBundle bundle = ResourceBundle.getBundle("beans");//不能书写文件后缀名
            //根据配置文件的key获取值
            String classNameStr = bundle.getString(key);
            //使用反射创建对象
            Class<?> Clazz = Class.forName(classNameStr);
             obj = Clazz.newInstance();//调用无参构造方法
            map.put(key,obj);

        }
    return (T)obj;
    }



}
