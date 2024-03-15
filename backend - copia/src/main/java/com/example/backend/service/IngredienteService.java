package com.example.backend.service;


import com.example.backend.models.Comida;
import com.example.backend.models.Ingrediente;

import java.util.Set;

public interface IngredienteService {
    Ingrediente agregarIngrediente(Ingrediente ingrediente);

    Ingrediente actualizarIngrediente(Ingrediente ingrediente);

    Ingrediente obtenerIngredientePorId(Long ingredienteId);

    Set<Ingrediente> obtenerIngredientes();

    Set<Ingrediente> listarIngredientesDeComida(Comida comida);

    void eliminarIngrediente(Long ingredienteId);
}
