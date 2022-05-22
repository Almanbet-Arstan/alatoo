package com.example.pizzaCafe.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @Column(name = "pizzas")
    private List<Pizza> pizzas;
}
