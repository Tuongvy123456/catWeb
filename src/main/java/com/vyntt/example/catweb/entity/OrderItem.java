package com.vyntt.example.catweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    private Cat cat;

    private int quantity;

    private double priceAtTime;

}
