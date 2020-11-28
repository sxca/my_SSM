package com.heima.factory;

import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}