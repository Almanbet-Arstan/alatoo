package com.example.pizzaCafe.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delievery extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @Column(name = "pizzas")
    private List<Pizza> pizzas;
}
