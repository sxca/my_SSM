package com.heima.test;

import com.heima.dao.IUserDao;
import com.heima.domain.User;
import com.heima.mybatis.io.Resources;
import com.heima.mybatis.sqlsession.SqlSession;
import com.heima.mybatis.sqlsession.SqlSessionFactory;
import com.heima.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.*;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();;
        in.close();

        Class cl1 = Random.class;
        Class cl2 = int.class;
        Class cl3 = Double[].class;

        System.out.println((Random)cl1.getConstructor().newInstance());
        System.out.println(cl2.getName());
        System.out.println(cl3.getName());

    }
}
