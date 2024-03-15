package com.example.backend.service;

import com.example.backend.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getListByClient(String username);

    void cleanShoppingCart(Long clientId);

    void removeComida(Long id);

    void addComida(ShoppingCart shoppingCart);

    Long getCountByClient(Long clientId);
}
