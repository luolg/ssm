package com.luolg.dao.impl;

import com.luolg.dao.RoleDao;
import com.luolg.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public int add(Role role) {
        int row = jdbcTemplate.update("insert  into sys_role (roleName,roleDesc) values(?,?)", role.getRoleName(), role.getRoleDesc());

        return row;
    }

    @Override
    public List<Role> findRoleById(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role a,sys_role b where a.roleId=b.id and a.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;

    }


}
