package com.example.backend.repository;

import com.example.backend.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findBySale_Id(Long saleId);
}
