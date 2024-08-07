package com.cai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.cai")
//开启aop功能
@EnableAspectJAutoProxy
public class springConfig {
}
