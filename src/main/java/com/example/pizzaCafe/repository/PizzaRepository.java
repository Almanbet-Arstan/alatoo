package com.example.pizzaCafe.repository;

import com.example.pizzaCafe.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
