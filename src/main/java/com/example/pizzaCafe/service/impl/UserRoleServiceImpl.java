package com.example.pizzaCafe.service.impl;

import com.example.pizzaCafe.entity.UserRole;
import com.example.pizzaCafe.repository.UserRoleRepository;
import com.example.pizzaCafe.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getById(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    @Override
    public UserRole updateUserRole(UserRole userRole) {
        UserRole userRoleForUpdate = getById(userRole.getId());

        if (userRole.getRoleName() != null) userRoleForUpdate.setRoleName(userRole.getRoleName());

        return userRoleRepository.save(userRoleForUpdate);
    }

    @Override
    public UserRole deleteById(Long id) {
        UserRole userRoleForDelete = getById(id);
        if (userRoleForDelete != null) userRoleRepository.delete(userRoleForDelete);

        return userRoleForDelete;
    }
}
