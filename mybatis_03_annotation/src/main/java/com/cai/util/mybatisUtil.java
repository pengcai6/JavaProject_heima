package com.cai.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类：静态方法+构造器
public class mybatisUtil {
    static SqlSessionFactory sqlSessionFactory;
    static  {

        //基于配置文件路径，创建字节输入流对象
        InputStream is;
        try {
            is = Resources.getResourceAsStream("mybatis_config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //创建SqlSessionFactory工厂类对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    /*
     *自动事务
     */
    public static SqlSession getSession(boolean flag) {//使用SqlSessionFactory工厂类,创建SqlSession对象
        return sqlSessionFactory.openSession(flag);
    }

    /**
     * 手动事务
     * @return  sqlsession对象
     */
    public static SqlSession getSession() {//使用SqlSessionFactory工厂类,创建SqlSession对象
        return sqlSessionFactory.openSession(true);
    }

    public static void closesqlSession(SqlSession sqlSession){
        if (sqlSession!=null)
            sqlSession.close();
    }
}