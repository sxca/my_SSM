package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.domain.Account;
import com.heima.service.IAccountService;
import com.heima.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl_OLD implements IAccountService {
    private TransactionManager txManager;
    private IAccountDao accountDao;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
            return accounts;

        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6.释放连接
            txManager.release();
        }
    }

    public Account findAccountById(Integer id) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
            Account account = accountDao.findAccountById(id);
            // 3.提交事务
            txManager.commit();
            // 4.返回结果
            return account;

        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6.释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
            accountDao.saveAccount(account);
            // 3.提交事务
            txManager.commit();

        } catch (Exception e) {
            // 4.回滚操作
            txManager.rollback();
        } finally {
            // 5.释放连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
            accountDao.updateAccount(account);
            // 3.提交事务
            txManager.commit();

        } catch (Exception e) {
            // 4.回滚操作
            txManager.rollback();
        } finally {
            // 5.释放连接
            txManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
            accountDao.deleteAccount(accountId);
            // 3.提交事务
            txManager.commit();

        } catch (Exception e) {
            // 4.回滚操作
            txManager.rollback();
        } finally {
            // 5.释放连接
            txManager.release();
        }

    }

    public void tranfer(String sourceName, String targetName, Float money) {
        try {
            // 1.开启事务
            txManager.beginTransaction();
            // 2.执行操作
                // 1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
                // 2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
                // 3.转出账户减钱
            source.setMoney(source.getMoney() - money);
                // 4.转入账户加钱
            target.setMoney(target.getMoney() + money);
                // 5.更新转出账户
            accountDao.updateAccount(source);
            int i = 1 / 0;
                // 6.更新转入账户
            accountDao.updateAccount(target);
            // 3.提交事务
            txManager.commit();

        } catch (Exception e) {
            // 4.回滚操作
            txManager.rollback();
            e.printStackTrace();
        } finally {
            // 5.释放连接
            txManager.release();
        }

    }
}
