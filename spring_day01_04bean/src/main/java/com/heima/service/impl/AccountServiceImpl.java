package com.heima.service.impl;

import com.heima.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了哦");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init() {
        System.out.println("对象初始化了。。。");
    }

    public void destory() {
        System.out.println("对象销毁了。。。");
    }
}
