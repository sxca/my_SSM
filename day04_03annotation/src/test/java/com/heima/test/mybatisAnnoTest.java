package com.heima.test;

import com.heima.dao.IUserDao;
import com.heima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.根据字节输入流构建SqlSessionFactory
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(in);
        // 3.根据SqlSessionFactory生产一个SqlSession对象
        SqlSession sqlSession = Factory.openSession();
        // 4.使用SqlSession获取Dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 5.执行Dao的方法
        List<User> users = userDao.findAll();
        // 6.释放资源
        sqlSession.close();
        in.close();

        for (User user: users) {
            System.out.println(user);
        }
    }


}
