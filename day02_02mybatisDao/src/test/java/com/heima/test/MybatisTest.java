package com.heima.test;

import com.heima.dao.IUserDao;
import com.heima.dao.impl.UserDaoImpl;
import com.heima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception{
        //6.释放资源
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
     * 测试保存方法
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("dao impl user");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());


        //5.使用代理对象执行方法
        userDao.save(user);

        System.out.println("保存操作之后：" + user);
    }

    /**
     * 测试更新方法
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("userdaoimpl updateUser");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());


        //5.使用代理对象执行方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除方法
     */
    @Test
    public void testDelete() {
        //5.使用代理对象执行方法
        userDao.deleteUser(54);
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
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }


}
