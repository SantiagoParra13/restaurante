package com.example.backend.controllers;


import com.example.backend.models.Categoria;
import com.example.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/categoria"})
@CrossOrigin({"*"})
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController() {
    }

    @GetMapping({"/{categoriaId}"})
    public Categoria obtenerCategoriaPorID(@PathVariable("categoriaId") Long categoriaId) {
        return this.categoriaService.obtenerCategoria(categoriaId);
    }

    @GetMapping({"/"})
    public ResponseEntity<?> listarCategorias() {
        return ResponseEntity.ok(this.categoriaService.obtenerCategorias());
    }

    @PostMapping({"/"})
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaGuardada = this.categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardada);
    }

    @PutMapping({"/"})
    public ResponseEntity<Categoria> actualizarCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaActualizada = this.categoriaService.actualizarCategoria(categoria);
        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping({"/{categoriaId}"})
    public void eliminarCategoria(@PathVariable("categoriaId") Long categoriId) {
        this.categoriaService.eliminarCategoria(categoriId);
    }
}