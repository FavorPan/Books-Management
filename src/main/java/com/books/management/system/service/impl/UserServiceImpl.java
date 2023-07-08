package com.books.management.system.service.impl;

import com.books.management.system.dao.UserDAO;
import com.books.management.system.entity.User;
import com.books.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Override
    public void deleteUser(String userId) {
        userDAO.deleteUser(userId);
    }
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Override
    public User getUserById(String userId) {
        return userDAO.getUserById(userId);
    }
}
