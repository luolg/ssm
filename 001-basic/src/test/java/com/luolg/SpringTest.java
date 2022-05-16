package com.luolg;

import com.luolg.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    //    @Test
    // test scope attribute
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        userDao1.save();
        userDao2.save();
    }

    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        userDao1.save();
        // test the destroy method
        ((ClassPathXmlApplicationContext) app).close();
    }
}
