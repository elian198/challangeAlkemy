package com.challangeAlkemy.service;

import com.challangeAlkemy.entities.Genero;
import com.challangeAlkemy.repository.GeneroRepositorio;
import com.challangeAlkemy.service.service.GeneroService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ApiModel("Clase de tipo servicio donde se implemanta toda la logica de la clase genero ")
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepositorio generos;

    public GeneroServiceImpl(GeneroRepositorio generos) {
        this.generos = generos;
    }


    @Override
    public List<Genero> listar() {
        return (List<Genero>) generos.findAll();
    }

    @Override
    public List<Genero> eliminar(Long id) {
        generos.deleteById(id);
        return (List<Genero>) generos.findAll();
    }

    @Override
    public Optional<Genero> crear(Genero genero) {
        generos.save(genero);
        return generos.findById(genero.getId_genero());
    }

    @Override
    public Optional<Genero> buscarPorId(Long id) {
        return generos.findById(id);
    }
}
