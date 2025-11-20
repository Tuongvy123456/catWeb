package com.vyntt.example.catweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_breeds")
public class CatBreed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedId;

    @NotNull(message = "Breed name is required!")
    private String breedName;

    @OneToMany(mappedBy = "breedId", fetch = FetchType.LAZY)
    private List<Cat> cats = new ArrayList<>();

    @NotNull(message = "Origin is required!")
    private String origin;

    private String description;

    @NotNull(message = "Created date is required!")
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
}
