package com.example.pizzaCafe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "address")
    private String address;
}
