package com.vyntt.example.catweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @NotNull(message = "Amount is required!")
    private double totalAmount;

    @NotNull(message = "Status is required!")
    private OrderStatus status;

    @NotNull(message = "Payment method is required!")
    private PaymentMethod method;

    @NotNull(message = "Created date is required")
    private LocalDateTime createdAt = LocalDateTime.now();

}
