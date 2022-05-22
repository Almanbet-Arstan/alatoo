package com.example.pizzaCafe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza extends BaseEntity{
    @Column(name = "pizza_name")
    private String pizzaName;

    @Column(name = "price")
    private Long price;

    @Column(name = "composition")
    private String composition;

    @OneToOne
    @JoinColumn(name = "pizza_image")
    private Image image;
}
