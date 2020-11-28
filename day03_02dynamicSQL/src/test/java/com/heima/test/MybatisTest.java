package com.heima.test;

import com.heima.dao.IUserDao;
import com.heima.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception{
        //提交事务
        //sqlSession.commit();

        //6.释放资源
        sqlSession.close();;
        in.close();
    }

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试根据id查询用户方法
     */
    @Test
    public void testFindOne() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试根据模糊查询方法
     */
    @Test
    public void testFindByUsername() {
        List<User> users = userDao.findByUserName("%王%");
        // List<User> users = userDao.findByUserName("王");
        for(User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUserName("老王");
        u.setUserSex("女");
        List<User> users = userDao.findUserByCondition(u);
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User user: users) {
            System.out.println(user);
        }
    }
}
