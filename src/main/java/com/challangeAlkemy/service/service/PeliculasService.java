package com.challangeAlkemy.service.service;

import com.challangeAlkemy.dto.PeliculaDtoITF;
import com.challangeAlkemy.entities.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculasService {

    List<Pelicula> eliminarPelicula(Long id);
    Optional<Pelicula> actualizarPelicula(Pelicula pelicula);
    Boolean crearPelicula(Pelicula pelicula);
    List<PeliculaDtoITF> listadoPeliculas();
    List<Pelicula> detalle();
    Optional<Pelicula> encontrarPorId(Long id);



}
