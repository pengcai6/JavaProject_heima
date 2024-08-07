package com.cai.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.lang.management.PlatformLoggingMXBean;

/**
 * @ClassName JdbcConfig
 * @Description Jdbc配置类
 * @Author gyl
 * @Date 22 15:41
 * @Version 1.0
 */
@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JdbcConfig{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * 实例化数据源
     * @author gyl
     * @date 22 16:54

     @return javax.sql.DataSource
     */
    @Bean("dataSource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(name);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


}
