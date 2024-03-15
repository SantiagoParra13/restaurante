package com.example.backend.service;

import com.example.backend.models.Detail;

import java.util.List;

public interface DetailService {
    void createDetail(Detail detail);

    List<Detail> getDetailBySale(Long saleId);
}

