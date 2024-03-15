package com.example.backend.repository;

import com.example.backend.models.Comida;
import com.example.backend.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    Set<Ingrediente> findByComida(Comida comida);
}

