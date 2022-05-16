package com.luolg.dao.impl;

import com.luolg.dao.UserDao;
import com.luolg.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private String username;
    private int age;
    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl creating ...");
    }

    public void init() {
        System.out.println("initialize method ... ");
    }

    public void destroy() {
        System.out.println("destroy method ... ");
    }

    public void save() {
        System.out.println("username: " + username + " age: " + age);
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("user dao impl saving .");

    }

}
