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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Username is required!")
    @Column(unique = true)
    private String userName;

    @NotNull(message = "Password is required!")
    @Column(unique = true)
    private String password;

    @NotNull(message = "Email is required!")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String address;

    @NotNull(message = "Role is required!")
    private Role role;

    @NotNull(message = "Created date is required!")
    private LocalDateTime createAt = LocalDateTime.now();
}
