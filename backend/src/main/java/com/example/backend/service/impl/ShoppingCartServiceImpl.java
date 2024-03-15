package com.example.backend.service.impl;

import com.example.backend.models.ShoppingCart;
import com.example.backend.repository.ShoppingCartRepository;
import com.example.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> getListByClient(String username) {
        return this.shoppingCartRepository.findByClient_username(username);
    }

    public void cleanShoppingCart(Long clientId) {
        this.shoppingCartRepository.deleteByClient_Id(clientId);
    }

    public void removeComida(Long id) {
        this.shoppingCartRepository.deleteById(id);
    }

    public void addComida(ShoppingCart shoppingCart) {
        this.shoppingCartRepository.save(shoppingCart);
    }

    public Long getCountByClient(Long clientId) {
        return this.shoppingCartRepository.countByClient_Id(clientId);
    }
}