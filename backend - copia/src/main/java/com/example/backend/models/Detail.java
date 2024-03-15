package com.example.backend.models;

import javax.persistence.*;

@Entity
public class Detail {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    private Comida comida;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    private Sale sale;
    private int amount;

    public Long getId() {
        return this.id;
    }

    public Comida getComida() {
        return this.comida;
    }

    public Sale getSale() {
        return this.sale;
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

    public void setSale(final Sale sale) {
        this.sale = sale;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public Detail(final Long id, final Comida comida, final Sale sale, final int amount) {
        this.id = id;
        this.comida = comida;
        this.sale = sale;
        this.amount = amount;
    }

    public Detail() {
    }
}