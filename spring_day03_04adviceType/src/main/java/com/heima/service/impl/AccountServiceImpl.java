package com.heima.service.impl;

import com.heima.service.IAccountService;

public class AccountServiceImpl implements IAccountService  {
    public void saveAccount() {

        System.out.println("执行了保存");
        // int i = 1 / 0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
