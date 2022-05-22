package com.example.pizzaCafe.repository;

import com.example.pizzaCafe.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
