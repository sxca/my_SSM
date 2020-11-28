package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.dao.impl.AccountDaoImpl;
import com.heima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("对象创建了哦");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
