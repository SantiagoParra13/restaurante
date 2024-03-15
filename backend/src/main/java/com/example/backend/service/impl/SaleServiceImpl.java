package com.example.backend.service.impl;


import com.example.backend.models.Detail;
import com.example.backend.models.Sale;
import com.example.backend.models.ShoppingCart;
import com.example.backend.models.Usuario;
import com.example.backend.repository.SaleRepository;
import com.example.backend.service.DetailService;
import com.example.backend.service.SaleService;
import com.example.backend.service.ShoppingCartService;
import com.example.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final UsuarioService usuarioService;
    private final ShoppingCartService shoppingCartService;
    private final DetailService detailService;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, UsuarioService usuarioService, ShoppingCartService shoppingCartService, DetailService detailService) {
        this.saleRepository = saleRepository;
        this.usuarioService = usuarioService;
        this.shoppingCartService = shoppingCartService;
        this.detailService = detailService;
    }

    public List<Sale> getSalesByClient(String username) {
        return this.saleRepository.findByClient_username(username);
    }

    public void createSale(String username) {
        Usuario client = this.usuarioService.obtenerUsuario(username);
        List<ShoppingCart> shoppingCartList = this.shoppingCartService.getListByClient(client.getUsername());
        DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        double total = shoppingCartList.stream().mapToDouble((shoppingCartItem) -> {
            return shoppingCartItem.getComida().getPrice() * (double)shoppingCartItem.getAmount();
        }).sum();
        Sale sale = new Sale(Double.parseDouble(decimalFormat.format(total)), new Date(), client);
        Sale saveSale = (Sale)this.saleRepository.save(sale);
        Iterator var10 = shoppingCartList.iterator();

        while(var10.hasNext()) {
            ShoppingCart shoppingCart = (ShoppingCart) ((Iterator<?>) var10).next();
            Detail detail = new Detail();
            detail.setComida(shoppingCart.getComida());
            detail.setAmount(shoppingCart.getAmount());
            detail.setSale(saveSale);
            this.detailService.createDetail(detail);
        }

        this.shoppingCartService.cleanShoppingCart(client.getId());
    }
}
