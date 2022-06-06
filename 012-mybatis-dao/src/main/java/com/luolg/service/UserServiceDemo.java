package com.luolg.service;

import com.luolg.dao.UserDao;
//import com.luolg.dao.impl.UserDaoImpl;
import com.luolg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceDemo {
    public static void main(String[] args) throws IOException {
//        UserDaoImpl userDao = new UserDaoImpl();
//        List<User> userList = userDao.finAll();
//        System.out.println(userList);

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.findAll());

        System.out.println(userDao.findById(1));

        sqlSession.close();

    }
}
