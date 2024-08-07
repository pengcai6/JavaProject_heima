package com.cai.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.cai")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();

    }
}
