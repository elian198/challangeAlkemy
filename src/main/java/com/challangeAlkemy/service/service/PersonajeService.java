package com.challangeAlkemy.service.service;

import com.challangeAlkemy.dto.PersonajeDTO;
import com.challangeAlkemy.dto.PersonajeDtoNyI;
import com.challangeAlkemy.entities.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonajeService {

    List<PersonajeDtoNyI> listaPersonajes();
    List<Personaje> detalle();
    Optional<Personaje> actualizar(Personaje personaje);
    Personaje crear(Personaje personaje);
    List<Personaje> eliminar(Long id);
    List<PersonajeDtoNyI> buscarNombre(String name);
    List<PersonajeDtoNyI> buscarEdad(Integer age);
    List<PersonajeDtoNyI> buscarPorPeso(Double peso);
    Optional<Personaje> buscarPorId(Long id);
}
