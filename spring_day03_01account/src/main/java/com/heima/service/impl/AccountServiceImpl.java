package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.domain.Account;
import com.heima.service.IAccountService;
import com.heima.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
       return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    public void tranfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
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

    }
}
