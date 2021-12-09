package com.zhijieketang.jpetstore.dao.mysql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "config/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);//io流引入mybatis 并拿到配置文件
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//配置文件为参数，并创建sqlSessionFactory的实例
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);//得到sqlSession,工厂模式
    }
}
