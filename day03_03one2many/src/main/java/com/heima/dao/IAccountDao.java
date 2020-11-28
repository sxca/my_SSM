package com.heima.dao;

import com.heima.domain.Account;
import com.heima.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，同事还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     */
    List<AccountUser> findAllAccount();
}
