package com.example.backend.controllers;

import com.example.backend.models.Detail;
import com.example.backend.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/saleDetail"})
@CrossOrigin({"*"})
public class DetailController {
    private final DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping({"/{sale_id}"})
    public ResponseEntity<List<Detail>> getDeatilsBySale(@PathVariable("sale_id") Long saleId) {
        return new ResponseEntity(this.detailService.getDetailBySale(saleId), HttpStatus.OK);
    }
}

