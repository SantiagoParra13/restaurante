package com.example.backend.controllers;

import com.example.backend.models.Categoria;
import com.example.backend.models.Comida;
import com.example.backend.models.Message;
import com.example.backend.repository.ComidaRepository;
import com.example.backend.service.CategoriaService;
import com.example.backend.service.ComidaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping({"/comida"})
@CrossOrigin({"*"})
public class ComidaController {
    @Autowired
    private ComidaService comidaService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ComidaRepository comidaRepository;

    public ComidaController() {
    }

    @PostMapping({"/"})
    public ResponseEntity<Comida> guardarComida( @RequestBody Comida comida) {
      return ResponseEntity.ok(comidaService.agregarComida(comida));
    }

    @GetMapping({"/{comidaId}"})
    public ResponseEntity<Comida> obtenerComidaPorId(@PathVariable("comidaId") long comidaId) {
        Optional<Comida> comidaOptional = this.comidaService.obtenerComidaPorId(comidaId);
        return comidaOptional.isPresent() ? new ResponseEntity((Comida)comidaOptional.get(), HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    @GetMapping({"/categoria/{categoriaId}"})
    public List<Comida> ListarComidaDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return this.comidaService.obtenerComidasDeCategoria(categoria);
    }

    @GetMapping({"/categoria/{category}/{comidaId}"})
    public ResponseEntity<Object> getRelatedProduct(@PathVariable("category") String categoria, @PathVariable("comidaId") Long comidaId) {
        return new ResponseEntity(this.comidaService.getRelatedProducts(categoria, comidaId), HttpStatus.OK);
    }

    @GetMapping({"/best"})
    public ResponseEntity<List<Comida>> getBestProducts() {
        return new ResponseEntity(this.comidaService.getBestPriceProducts(), HttpStatus.OK);
    }

    @GetMapping({"/"})
    public ResponseEntity<?> listarTodasLasComidas() {
        return ResponseEntity.ok(this.comidaService.listarComidas());
    }

    @PutMapping({"/"})
    public ResponseEntity<Comida> actualizarComida(@RequestBody Comida comida) {
        Comida comidaGuardada = this.comidaService.actualizarComida(comida);
        return new ResponseEntity(comidaGuardada, HttpStatus.OK);
    }

    @DeleteMapping({"/{comidaId}"})
    public ResponseEntity<Map<String, String>> eliminarComida(@PathVariable Long comidaId) {
        this.comidaService.eliminarComida(comidaId);
        Map<String, String> response = new HashMap();
        response.put("message", "Comida eliminada correctamente");
        return ResponseEntity.ok(response);
    }
}
