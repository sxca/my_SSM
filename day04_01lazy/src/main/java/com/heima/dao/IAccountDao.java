package com.heima.dao;

import com.heima.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，同事还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户
     */
    List<Account> findAccountById(int uid);
}
