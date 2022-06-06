package com.luolg.dao;

import com.luolg.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User findById(Integer id);
}
