package com.heima.mybatis.sqlsession;

import com.heima.mybatis.cfg.Configuration;
import com.heima.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.heima.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactoryBuilder对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
