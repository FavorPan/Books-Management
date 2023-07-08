package com.books.management.system.dao;

import com.books.management.system.entity.User;

public interface UserDAO {
    void addUser(User user);
    void deleteUser(String userId);
    void updateUser(User user);
    User getUserById(String userId);
}
