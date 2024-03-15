package com.example.backend.repository;

import com.example.backend.models.Categoria;
import com.example.backend.models.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
    List<Comida> findByCategoria(Categoria categoria);

    Optional<Comida> findByNombre(String nombre);

    List<Comida> findByCategoriaAndIdNot(String categoria, Long ProductId);

    List<Comida> findFirst8ByOrderByPriceAsc();
}
