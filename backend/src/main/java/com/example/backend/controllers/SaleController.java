package com.example.backend.controllers;


import com.example.backend.models.Message;
import com.example.backend.models.Sale;
import com.example.backend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/sale"})
@CrossOrigin({"*"})
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping({"/client"})
    public ResponseEntity<List<Sale>> getByClient() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        return new ResponseEntity(this.saleService.getSalesByClient(userName), HttpStatus.OK);
    }

    @GetMapping({"/{username}"})
    public ResponseEntity<List<Sale>> getAllSale(@PathVariable("username") String usrename) {
        return new ResponseEntity(this.saleService.getSalesByClient(usrename), HttpStatus.OK);
    }

    @PostMapping({"/create"})
    public ResponseEntity<Message> createSale() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        this.saleService.createSale(userName);
        return new ResponseEntity(new Message("Compra exitosa"), HttpStatus.OK);
    }
}

