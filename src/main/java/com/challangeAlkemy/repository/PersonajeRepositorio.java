package com.challangeAlkemy.repository;

import com.challangeAlkemy.entities.Pelicula;
import com.challangeAlkemy.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, Long> {

    @Query(value = "SELECT * FROM personaje WHERE nombre LIKE  %:filtro% ", nativeQuery = true)
    List<Personaje> buscarPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM personaje p WHERE p.edad = :filtro", nativeQuery = true)
    public List<Personaje> buscarPorEdad(Integer filtro);

    @Query(value = "SELECT * FROM personaje WHERE peso =:filtro ", nativeQuery = true)
    List<Personaje> buscarPorPeso(Double filtro);
    

}
