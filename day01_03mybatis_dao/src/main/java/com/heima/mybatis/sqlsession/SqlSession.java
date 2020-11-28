package com.heima.mybatis.sqlsession;

/**
 * 自定义Mybatis中和数据库交互的核心类
 * 他里面可以创建dao接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
