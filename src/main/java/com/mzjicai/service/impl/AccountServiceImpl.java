package com.mzjicai.service.impl;

import com.mzjicai.dao.AccountDao;
import com.mzjicai.domain.Account;
import com.mzjicai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service业务层：保存帐户...");
        accountDao.saveAccount(account);
    }
}
