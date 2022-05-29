package com.luolg.service.impl;

import com.luolg.dao.UserDao;
import com.luolg.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;


    //way two,  replaced by the constructor method with para
    //    public void setUserDao(UserDao userDao) {
    //        this.userDao = userDao;
    //    }


    public UserServiceImpl() {
    }

    // way three with constructor
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public void save() {
        // way one,  replaced by setUserDao method
        //        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }


}
