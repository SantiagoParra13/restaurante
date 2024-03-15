package com.example.backend.service.impl;


import com.example.backend.models.Detail;
import com.example.backend.repository.DetailRepository;
import com.example.backend.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailRepository detailRepository;

    public DetailServiceImpl() {
    }

    public void createDetail(Detail detail) {
        this.detailRepository.save(detail);
    }

    public List<Detail> getDetailBySale(Long saleId) {
        return this.detailRepository.findBySale_Id(saleId);
    }
}
