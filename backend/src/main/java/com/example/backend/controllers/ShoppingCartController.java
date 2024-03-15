package com.example.backend.controllers;

import com.example.backend.models.Message;
import com.example.backend.models.ShoppingCart;
import com.example.backend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/shoppingList"})
@CrossOrigin({"*"})
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping({"/"})
    public ResponseEntity<List<ShoppingCart>> getListByClient() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String userName = userDetails.getUsername();
            List<ShoppingCart> shoppingCarts = this.shoppingCartService.getListByClient(userName);
            return new ResponseEntity(shoppingCarts, HttpStatus.OK);
        } catch (Exception var4) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/count/{clienteId}"})
    public ResponseEntity<Long> countByClient(@PathVariable("clienteId") Long id) {
        return new ResponseEntity(this.shoppingCartService.getCountByClient(id), HttpStatus.OK);
    }

    @PostMapping({"/"})
    public ResponseEntity<Message> addProduct(@RequestBody ShoppingCart shoppingCart, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Revise los Campos"), HttpStatus.BAD_REQUEST);
        } else {
            this.shoppingCartService.addComida(shoppingCart);
            System.out.println("Producto agregado");
            return new ResponseEntity(new Message("Producto Agregado"), HttpStatus.OK);
        }
    }

    @DeleteMapping({"/clean/{item_id}"})
    public ResponseEntity<Message> removeProduct(@PathVariable("item_id") Long id) {
        this.shoppingCartService.removeComida(id);
        return new ResponseEntity(new Message("Eliminado"), HttpStatus.OK);
    }
}

