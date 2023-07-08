package com.books.management.system.service;

import com.books.management.system.entity.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(String userId);
    void updateUser(User user);
    User getUserById(String userId);
}
