package com.cai.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import java.text.CharacterIterator;

public class ServletContainInitConfig extends AbstractDispatcherServletInitializer {
    //创建SpringMvc容器
   @Override
    protected WebApplicationContext createServletApplicationContext() {
       AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
       ctx.register(springConfig.class);
        return ctx;
    }
    //设置哪些请求交给SpringMvc处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //创建spring容器
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
    //设置参数编码为UTF-8
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
