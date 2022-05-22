package com.example.pizzaCafe.repository;

import com.example.pizzaCafe.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
