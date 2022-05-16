package com.luolg.service.impl;

import com.luolg.dao.UserDao;
import com.luolg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.annotation.Resource;
import java.security.PrivateKey;

//<bean id="userService" class="com.luolg.service.impl.UserServiceImpl">
//<property name="userDao" ref="userDao"/>
//</bean>

//@Component("userService")
@Service("userService")
@Scope("singleton")
//@Scope("prototype")
public class UserServiceImpl implements UserService {
    //    @Value("lao si ji dai dai wo")
    @Value("${jdbc.username}")
    private String driver;

//    @Autowired // according to the data type, spring would choose it after scan the beans
//    @Qualifier("userDao") // user together with Autowired, and match according to the container id

    @Resource(name = "userDao") // it is composed of Autowired & Qualifier
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
        System.out.println(driver);
    }

    @PostConstruct
    public void init() {
        System.out.println("Service object init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service object destroy method");
    }
}
