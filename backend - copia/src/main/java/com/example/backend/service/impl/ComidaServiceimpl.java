package com.example.backend.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import com.example.backend.models.Categoria;
import com.example.backend.models.Comida;
import com.example.backend.repository.ComidaRepository;
import com.example.backend.repository.IngredienteRepository;
import com.example.backend.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ComidaServiceimpl implements ComidaService {
    @Autowired
    private ComidaRepository comidaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;



    public Comida agregarComida(Comida comida) {
        Optional<Comida> comidaExistente = this.comidaRepository.findByNombre(comida.getNombre());
        if (comidaExistente.isPresent()) {
            throw new RuntimeException("La comida ya existe en la base de datos.");
        } else {
            return comidaRepository.save(comida);
        }
    }

    public Comida actualizarComida(Comida comida) {
        return (Comida)this.comidaRepository.save(comida);
    }

    public Optional<Comida> obtenerComidaPorId(Long comidaId) {
        return this.comidaRepository.findById(comidaId);
    }

    public Set<Comida> listarComidas() {
        return new LinkedHashSet(this.comidaRepository.findAll());
    }

    public List<Comida> obtenerComidasDeCategoria(Categoria categoria) {
        return this.comidaRepository.findByCategoria(categoria);
    }

    @Transactional
    public void eliminarComida(Long comidaId) {
        Optional<Comida> comidaOptional = this.comidaRepository.findById(comidaId);
        comidaOptional.ifPresent((comida) -> {
            this.comidaRepository.delete(comida);
        });
    }

    public List<Comida> getRelatedProducts(String categoria, Long comidaId) {
        List<Comida> comidaList = this.comidaRepository.findByCategoriaAndIdNot(categoria, comidaId);
        List<Comida> randomComidas = new ArrayList();
        Random random = new Random();

        for(int i = 0; i < 2; ++i) {
            int randomIndex = random.nextInt(comidaList.size());
            randomComidas.add((Comida)comidaList.get(randomIndex));
            comidaList.remove(randomIndex);
        }

        return randomComidas;
    }

    public List<Comida> getBestPriceProducts() {
        return this.comidaRepository.findFirst8ByOrderByPriceAsc();
    }
}
