package com.example.backend.models;


import javax.persistence.*;

@Entity
public class Ingrediente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nombre;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Comida comida;

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Comida getComida() {
        return this.comida;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setComida(final Comida comida) {
        this.comida = comida;
    }

    public Ingrediente() {
    }

    public Ingrediente(final Long id, final String nombre, final Comida comida) {
        this.id = id;
        this.nombre = nombre;
        this.comida = comida;
    }
}
