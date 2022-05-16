package com.luolg.service.impl;

import com.luolg.service.UserService;
import com.luolg.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }


}
