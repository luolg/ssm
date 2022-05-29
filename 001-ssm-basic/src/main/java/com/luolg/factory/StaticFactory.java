package com.luolg.factory;

import com.luolg.dao.UserDao;
import com.luolg.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
