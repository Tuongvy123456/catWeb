package com.vyntt.example.catweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    @NotNull(message = "Cat's name is required!")
    @Column(unique = true)
    private String catName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breedId", nullable = false)
    private CatBreed catBreed;

    @NotNull(message = "Cat's age is required!")
    private int age;

    @NotNull(message = "Cat's gender is required!")
    private CatGender gender;

    private String description;

    @NotNull(message = "Cat's price is required!")
    private double price;

    @NotNull
    private CatStatus status;

    @NotNull(message = "Created date is required!")
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
