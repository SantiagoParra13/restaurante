package com.example.backend.repository;

import com.example.backend.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByClient_Id(Long clienteId);

    List<ShoppingCart> findByClient_username(String username);

    void deleteByClient_Id(Long clientId);

    Long countByClient_Id(Long id);
}
