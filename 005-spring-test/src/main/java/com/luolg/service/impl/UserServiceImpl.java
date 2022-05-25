package com.luolg.service.impl;

import com.luolg.dao.RoleDao;
import com.luolg.dao.UserDao;
import com.luolg.domain.Role;
import com.luolg.domain.User;
import com.luolg.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleById(id);
            user.setRoleList(roleList);
        }
        return userList;
    }

    @Override
    public void addUser(User user, Long[] roleIds) {
        long userId = userDao.addUser(user);
        System.out.println(user);
        System.out.println("user id " + user.getId());
        userDao.saveUserRole(userId, roleIds);

    }

    @Override
    public void delete(Long userId) {
        //delete relation table record
        userDao.deleteUserRoleRelation(userId);
        //delete user table record
        userDao.deleteUser(userId);
    }
}
