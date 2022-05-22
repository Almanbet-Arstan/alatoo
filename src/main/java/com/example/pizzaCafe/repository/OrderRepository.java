package com.example.pizzaCafe.repository;

import com.example.pizzaCafe.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
