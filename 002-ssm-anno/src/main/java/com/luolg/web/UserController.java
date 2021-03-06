package com.luolg.web;

import com.luolg.config.SpringConfiguration;
import com.luolg.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
//        ((ClassPathXmlApplicationContext) app).close();
        ((AnnotationConfigApplicationContext) app).close();
    }
}
