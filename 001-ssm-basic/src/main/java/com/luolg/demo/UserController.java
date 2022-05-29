package com.luolg.demo;

import com.luolg.service.UserService;
import com.luolg.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("C:\\Users\\luolg\\development\\myjava\\001-app\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
        UserService userService = app.getBean(UserService.class);
        userService.save();

//        UserService userService = new UserServiceImpl();
//        userService.save();
//        Cannot invoke "com.luolg.dao.UserDao.save()" because "this.userDao" is null

    }
}
