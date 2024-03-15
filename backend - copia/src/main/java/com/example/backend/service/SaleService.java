package com.example.backend.service;

import com.example.backend.models.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getSalesByClient(String usernam);

    void createSale(String username);
}
