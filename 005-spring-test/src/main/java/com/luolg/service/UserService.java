package com.luolg.service;

import com.luolg.domain.User;

import java.util.List;

public interface UserService {
    public List<User> list();

    public void addUser(User user, Long[] roleIds);

    void delete(Long userId);
}
