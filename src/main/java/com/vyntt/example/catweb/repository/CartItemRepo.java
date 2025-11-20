package com.vyntt.example.catweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vyntt.example.catweb.entity.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {

}
