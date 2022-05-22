package com.example.pizzaCafe.service;

import com.example.pizzaCafe.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAll();
    User getById(Long id);
    User updateUser(User user);
    User deleteById(Long id);
}
