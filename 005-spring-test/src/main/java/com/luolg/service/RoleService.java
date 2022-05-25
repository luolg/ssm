package com.luolg.service;

import com.luolg.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();
    public int addRole(Role role);
}
