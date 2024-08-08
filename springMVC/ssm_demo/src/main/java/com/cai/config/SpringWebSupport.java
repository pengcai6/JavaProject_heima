package com.cai.config;

import com.cai.interceptor.MyInterceptor;
import com.cai.interceptor.MyInterceptor2;
import com.cai.interceptor.MyInterceptor3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 实现类-设置静态资源访问路径
 */

public class SpringWebSupport implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;
    @Autowired
    private MyInterceptor2 myInterceptor2;
    @Autowired
    private MyInterceptor3 myInterceptor3;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
      registry.addResourceHandler("/css/**").addResourceLocations("/css/");
      registry.addResourceHandler("/js/**").addResourceLocations("/js/");
      registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
    //配置拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     registry.addInterceptor(myInterceptor).addPathPatterns("/books");
     registry.addInterceptor(myInterceptor2).addPathPatterns("/books");
     registry.addInterceptor(myInterceptor3).addPathPatterns("/books");
    }
}
