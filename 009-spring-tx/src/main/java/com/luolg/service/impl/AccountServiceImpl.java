package com.luolg.service.impl;

import com.luolg.dao.AccountDao;
import com.luolg.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transfer(String outMan, String inMan, double money) {
        // open transaction
        accountDao.out(outMan, money);
//        int i = 1 / 0;
        accountDao.in(inMan, money);
        // submit transaction
    }
}
