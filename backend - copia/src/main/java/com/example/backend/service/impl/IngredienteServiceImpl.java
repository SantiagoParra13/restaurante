package com.example.backend.service.impl;


import com.example.backend.models.Comida;
import com.example.backend.models.Ingrediente;
import com.example.backend.repository.IngredienteRepository;
import com.example.backend.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public IngredienteServiceImpl() {
    }

    public Ingrediente agregarIngrediente(Ingrediente ingrediente) {
        return (Ingrediente)this.ingredienteRepository.save(ingrediente);
    }

    public Ingrediente actualizarIngrediente(Ingrediente ingrediente) {
        return (Ingrediente)this.ingredienteRepository.save(ingrediente);
    }

    public Ingrediente obtenerIngredientePorId(Long ingredienteId) {
        return (Ingrediente)this.ingredienteRepository.findById(ingredienteId).get();
    }

    public Set<Ingrediente> obtenerIngredientes() {
        return new LinkedHashSet(this.ingredienteRepository.findAll());
    }

    public Set<Ingrediente> listarIngredientesDeComida(Comida comida) {
        return this.ingredienteRepository.findByComida(comida);
    }

    public void eliminarIngrediente(Long ingredienteId) {
        try {
            Optional<Ingrediente> comidaOptional = this.ingredienteRepository.findById(ingredienteId);
            comidaOptional.ifPresent((ingrediente) -> {
                this.ingredienteRepository.delete(ingrediente);
            });
        } catch (EmptyResultDataAccessException var3) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado", var3);
        }
    }
}
