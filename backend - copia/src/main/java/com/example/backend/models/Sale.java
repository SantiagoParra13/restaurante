package com.example.backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sale {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Double total;
    @Column(
            columnDefinition = "DATE"
    )
    private Date date;
    @ManyToOne(
            optional = false,
            cascade = {CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    private Usuario client;

    public Sale(Double total, Date date, Usuario client) {
        this.total = total;
        this.date = date;
        this.client = client;
    }

    public Long getId() {
        return this.id;
    }

    public Double getTotal() {
        return this.total;
    }

    public Date getDate() {
        return this.date;
    }

    public Usuario getClient() {
        return this.client;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTotal(final Double total) {
        this.total = total;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public void setClient(final Usuario client) {
        this.client = client;
    }

    public Sale() {
    }

    public Sale(final Long id, final Double total, final Date date, final Usuario client) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.client = client;
    }
}
