package com.cai.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spirng核心配置类·
 */

@Configuration
//精准扫描
//@ComponentScan({"com.cai.dao","com.cai.service"})
//扫描后排除
@ComponentScan(value = "com.cai", excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION, classes = {Controller.class,Configuration.class}))
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
//开启事务
@EnableTransactionManagement
public class SpringConfig {

}
