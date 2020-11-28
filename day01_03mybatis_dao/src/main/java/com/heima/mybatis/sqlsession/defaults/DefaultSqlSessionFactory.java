package com.heima.mybatis.sqlsession.defaults;

import com.heima.mybatis.cfg.Configuration;
import com.heima.mybatis.sqlsession.SqlSession;
import com.heima.mybatis.sqlsession.SqlSessionFactory;

import java.io.InputStream;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
