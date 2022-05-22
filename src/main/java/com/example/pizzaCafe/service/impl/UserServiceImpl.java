package com.example.pizzaCafe.service.impl;

import com.example.pizzaCafe.entity.User;
import com.example.pizzaCafe.entity.UserRole;
import com.example.pizzaCafe.repository.UserRepository;
import com.example.pizzaCafe.service.UserRoleService;
import com.example.pizzaCafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setUserRole(userRoleService.getById(1L));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        User userForUpdate = getById(user.getId());

        if (user.getLogin() != null) userForUpdate.setLogin(user.getLogin());
        if (user.getPassword() != null) userForUpdate.setLogin(user.getLogin());
        if (user.getEmail() != null) userForUpdate.setLogin(user.getLogin());

        return userRepository.save(userForUpdate);
    }

    @Override
    public User deleteById(Long id) {
        User userForDelete = getById(id);
        if (userForDelete != null) userRepository.delete(userForDelete);

        return userForDelete;
    }
}
