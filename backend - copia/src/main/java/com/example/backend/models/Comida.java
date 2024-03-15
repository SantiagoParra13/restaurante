package com.example.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "comida"
)
public class Comida {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nombre;
    private String descripcion;
    private Double price;
    private int stars;

    private String image;
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH}
    )
    private Categoria categoria;
    @OneToMany(
            mappedBy = "comida",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private Set<Ingrediente> ingredientes = new HashSet();

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getStars() {
        return this.stars;
    }



    public Categoria getCategoria() {
        return this.categoria;
    }

    public Set<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setStars(final int stars) {
        this.stars = stars;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

    public Comida(Long id, String nombre, String descripcion, Double price, int stars, String image, Categoria categoria, Set<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.price = price;
        this.stars = stars;
        this.image = image;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
    }

    @JsonIgnore
    public void setIngredientes(final Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Comida() {
    }


}

