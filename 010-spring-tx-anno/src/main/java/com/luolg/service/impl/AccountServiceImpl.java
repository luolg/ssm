package com.luolg.service.impl;

import com.luolg.dao.AccountDao;
import com.luolg.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        // open transaction
        accountDao.out(outMan, money);
        int i = 1 / 0;
        accountDao.in(inMan, money);
        // submit transaction
    }
}
