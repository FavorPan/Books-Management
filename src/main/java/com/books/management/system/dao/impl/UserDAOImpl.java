package com.books.management.system.dao.impl;

import com.books.management.system.dao.UserDAO;
import com.books.management.system.entity.User;
import com.books.management.system.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO User (user_id, username, password, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail());
    }
    public void updateUser(User user) {
        String sql = "UPDATE User SET username = ?, password = ?, email = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getUserId());
    }
    public void deleteUser(String userId) {
        String sql = "DELETE FROM User WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
    public User getUserById(String userId) {
        String sql = "SELECT * FROM User WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId);
    }
}
