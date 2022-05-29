package com.luolg.dao;

import com.luolg.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public long addUser(User user);

    public void saveUserRole(Long userId, Long[] roleIds);

    void deleteUserRoleRelation(Long userId);

    void deleteUser(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
