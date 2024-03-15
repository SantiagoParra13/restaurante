package com.example.backend.models;


import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
   name = "categorias"
)
public class Categoria {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long categoriaId;
   private String titulo;
   private String descripcion;
   private boolean ativo = true;
   @OneToMany(
      mappedBy = "categoria",
      cascade = {CascadeType.ALL}
   )
   @JsonIgnore
   private Set<Comida> comidas = new HashSet();

   public void setCategoriaId(final Long categoriaId) {
      this.categoriaId = categoriaId;
   }

   public void setTitulo(final String titulo) {
      this.titulo = titulo;
   }

   public void setDescripcion(final String descripcion) {
      this.descripcion = descripcion;
   }

   public void setAtivo(final boolean ativo) {
      this.ativo = ativo;
   }

   @JsonIgnore
   public void setComidas(final Set<Comida> comidas) {
      this.comidas = comidas;
   }

   public Long getCategoriaId() {
      return this.categoriaId;
   }

   public String getTitulo() {
      return this.titulo;
   }

   public String getDescripcion() {
      return this.descripcion;
   }

   public boolean isAtivo() {
      return this.ativo;
   }

   public Set<Comida> getComidas() {
      return this.comidas;
   }

   public Categoria() {
   }

   public Categoria(final Long categoriaId, final String titulo, final String descripcion, final boolean ativo, final Set<Comida> comidas) {
      this.categoriaId = categoriaId;
      this.titulo = titulo;
      this.descripcion = descripcion;
      this.ativo = ativo;
      this.comidas = comidas;
   }
}