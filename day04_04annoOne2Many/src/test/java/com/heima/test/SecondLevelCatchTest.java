package com.heima.test;

import com.heima.dao.IUserDao;
import com.heima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class SecondLevelCatchTest {
    private InputStream in;
    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void destory() throws Exception {
        in.close();
    }

    @Test
    public void testFindById() {
        SqlSession session = factory.openSession();;
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(58);
        System.out.println(user);
        // 释放一级缓存
        session.close();

        SqlSession session1 = factory.openSession();
        IUserDao userDao1 = session1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(58);
        System.out.println(user1);

        session1.close();

    }
}
