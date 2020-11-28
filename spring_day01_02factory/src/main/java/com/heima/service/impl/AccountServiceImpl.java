package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.dao.impl.AccountDaoImpl;
import com.heima.factory.BeanFactory;
import com.heima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    // private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");
    private int i = 0;
    public void saveAccount() {

        System.out.println(i);
        accountDao.saveAccount();
        i++;
    }
}
