package com.luolg.dao.impl;

import com.luolg.dao.UserDao;
import com.luolg.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user;", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public long addUser(User user) {
//        int row = jdbcTemplate.update("insert into sys_user (id,username, email, password, phoneNum) values(?,?,?,?,?)",
//                null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //use jdbc to realize the PreparedStatement
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user (id,username, email, password, phoneNum) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, holder);
        long userId = holder.getKey().longValue();

        return userId;
    }

    @Override
    public void saveUserRole(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role(userId, roleId) values (?,?)", userId, roleId);
        }
    }

    @Override
    public void deleteUserRoleRelation(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?",
                new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
