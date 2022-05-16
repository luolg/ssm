package com.luolg.dao.impl;

import com.luolg.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.luolg.dao.impl.UserDaoImpl"/>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save(){
        System.out.println("UserDaoImpl save method running ...");
    }
}
