package com.luolg.dao;

import com.luolg.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    public int add(Role role);

    List<Role> findRoleById(Long id);
}
