package com.example.backend.controllers;


import com.example.backend.models.Comida;
import com.example.backend.models.Ingrediente;
import com.example.backend.service.ComidaService;
import com.example.backend.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping({"/ingrediente"})
@CrossOrigin({"*"})
public class IngredienteController {
    @Autowired
    private ComidaService comidaService;
    @Autowired
    private IngredienteService ingredienteService;

    public IngredienteController() {
    }

    @PostMapping({"/"})
    public ResponseEntity<Ingrediente> guardarIngrediente(@RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(this.ingredienteService.agregarIngrediente(ingrediente));
    }

    @PutMapping({"/"})
    public ResponseEntity<Ingrediente> actualizarIngrediente(@RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(this.ingredienteService.actualizarIngrediente(ingrediente));
    }

    @GetMapping({"/"})
    public ResponseEntity<Set<Ingrediente>> obtenerTodosLosIngredientes() {
        return ResponseEntity.ok(this.ingredienteService.obtenerIngredientes());
    }

    @GetMapping({"/comida/{comidaId}"})
    public ResponseEntity<List<Ingrediente>> listarIngredientesDeLaComida(@PathVariable("comidaId") Long comidaId) {
        Optional<Comida> comidaOptional = this.comidaService.obtenerComidaPorId(comidaId);
        if (comidaOptional.isPresent()) {
            Comida var3 = (Comida)comidaOptional.get();
            var3 = (Comida)comidaOptional.get();
            Set ingredientes = var3.getIngredientes();
            ArrayList var5 = new ArrayList(ingredientes);
            return ResponseEntity.ok(var5);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping({"/{ingredienteId}"})
    public Ingrediente listarIngredientePorId(@PathVariable("ingredienteId") Long ingredienteId) {
        return this.ingredienteService.obtenerIngredientePorId(ingredienteId);
    }

    @DeleteMapping({"/{ingredienteId}"})
    public void eliminarIngrediente(@PathVariable("ingredienteId") Long ingredienteId) {
        this.ingredienteService.eliminarIngrediente(ingredienteId);
    }
}
