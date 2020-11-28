package com.heima.dao.impl;

import com.heima.dao.IUserDao;
import com.heima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法，实现查询列表
        // 配置文件中的IUserDao.xml中的namespace+文件中的标签名称
        List<User> users = session.selectList("com.heima.dao.IUserDao.findAll");
        // 3.释放资源
        session.close();
        return users;
    }

    public void save(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现保存
        session.insert("com.heima.dao.IUserDao.save", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    public void updateUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现更新
        session.delete("com.heima.dao.IUserDao.updateUser", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();

    }

    public void deleteUser(Integer userId) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现删除
        session.delete("com.heima.dao.IUserDao.deleteUser", userId);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    public User findById(Integer id) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现查询一个
        User user = session.selectOne("com.heima.dao.IUserDao.findById", id);
        // 3.释放资源
        session.close();
        return user;
    }

    public List<User> findByUserName(String username) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现查询一个
        List<User> users = session.selectList("com.heima.dao.IUserDao.findByUserName", username);
        // 3.释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用方法，实现查询一个
        int count = session.selectOne("com.heima.dao.IUserDao.findTotal");
        // 3.释放资源
        session.close();
        return count;
    }
}
