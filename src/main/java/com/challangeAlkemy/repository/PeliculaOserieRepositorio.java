package com.challangeAlkemy.repository;

import com.challangeAlkemy.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeliculaOserieRepositorio extends JpaRepository<Pelicula, Long> {
    @Query(value = "SELECT * FROM  pelicula  WHERE pelicula.titulo LIKE  %:filtro% ", nativeQuery = true)
     List<Pelicula> buscarPorTitulo(@Param("filtro") String filtro);

    @Query(value = "SELECT * from pelicula order by fecha" , nativeQuery = true)
     List<Pelicula> ordenarASC();

    @Query(value = "SELECT * from pelicula order by fecha desc" , nativeQuery = true)
    List<Pelicula> ordenarDESC();

}
