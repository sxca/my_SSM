package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service(value = "accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Value("hahaha")
    private String msg;
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(msg);
    }
    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁方法执行了");
    }
}
