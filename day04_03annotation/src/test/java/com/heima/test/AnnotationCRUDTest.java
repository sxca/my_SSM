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

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);

    }

    @After
    public void destory() throws Exception {
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京市朝阳区");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(58);
        user.setUsername("Mybatis annotion");
        user.setAddress("北京市昌平区");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(56);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(58);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        // List<User> users = userDao.findUserByName("%王%");
        List<User> users = userDao.findUserByName("王");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
