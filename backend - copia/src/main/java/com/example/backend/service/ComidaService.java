package com.example.backend.service;


import com.example.backend.models.Categoria;
import com.example.backend.models.Comida;


import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ComidaService {
    Comida agregarComida(Comida comida);

    Comida actualizarComida(Comida comida);

    Optional<Comida> obtenerComidaPorId(Long comidaId);

    Set<Comida> listarComidas();

    List<Comida> obtenerComidasDeCategoria(Categoria categoria);

    void eliminarComida(Long comidaId);

    List<Comida> getRelatedProducts(String categoria, Long comidaId);

    List<Comida> getBestPriceProducts();
}