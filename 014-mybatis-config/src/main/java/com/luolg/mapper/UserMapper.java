package com.luolg.mapper;

import com.luolg.domain.User;

import java.util.List;

public interface UserMapper {
    public void save(User user);

    public User findById(int id);

    public List<User> findAll();
}
