package com.cai.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.cai")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {

}
