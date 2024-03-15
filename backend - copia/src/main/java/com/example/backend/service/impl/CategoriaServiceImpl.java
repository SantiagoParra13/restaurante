package com.example.backend.service.impl;


import com.example.backend.models.Categoria;
import com.example.backend.repository.CategoriaRepository;
import com.example.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl() {
    }

    public Categoria agregarCategoria(Categoria categoria) {
        Optional<Categoria> categoriaExistente = this.categoriaRepository.findByTitulo(String.valueOf(categoria.getTitulo()));
        if (categoriaExistente.isPresent()) {
            throw new RuntimeException("La Categoria ya existe en la base de datos.");
        } else {
            return (Categoria)this.categoriaRepository.save(categoria);
        }
    }

    public Categoria actualizarCategoria(Categoria categoria) {
        return (Categoria)this.categoriaRepository.save(categoria);
    }

    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet(this.categoriaRepository.findAll());
    }

    public Categoria obtenerCategoria(Long categoriaId) {
        return (Categoria)this.categoriaRepository.findById(categoriaId).get();
    }

    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        this.categoriaRepository.delete(categoria);
    }
}

