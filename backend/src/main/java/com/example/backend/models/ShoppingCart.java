package com.example.backend.models;

import javax.persistence.*;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    private Comida comida;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    private Usuario client;
    private int amount;

    public Long getId() {
        return this.id;
    }

    public Comida getComida() {
        return this.comida;
    }

    public Usuario getClient() {
        return this.client;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setComida(final Comida comida) {
        this.comida = comida;
    }

    public void setClient(final Usuario client) {
        this.client = client;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public ShoppingCart(final Long id, final Comida comida, final Usuario client, final int amount) {
        this.id = id;
        this.comida = comida;
        this.client = client;
        this.amount = amount;
    }

    public ShoppingCart() {
    }
}
