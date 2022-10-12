package com.challangeAlkemy.service.service;

import com.challangeAlkemy.entities.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroService {

    List<Genero> listar();
    List<Genero> eliminar(Long id);
    Optional<Genero> crear(Genero genero);
    Optional<Genero> buscarPorId(Long id);

}
