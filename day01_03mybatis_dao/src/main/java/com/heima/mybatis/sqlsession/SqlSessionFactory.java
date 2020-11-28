package com.heima.mybatis.sqlsession;

import java.io.InputStream;

public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
