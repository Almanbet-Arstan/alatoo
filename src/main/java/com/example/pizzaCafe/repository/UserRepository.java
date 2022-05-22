package com.example.pizzaCafe.repository;

import com.example.pizzaCafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
