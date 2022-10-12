package com.challangeAlkemy.dto;


import com.challangeAlkemy.entities.Pelicula;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonajeDTO implements Serializable {

    private Long id;
    private String nombre;
    private String imagen;
    private int edad;
    private Double peso;
    private String historia;
    private Set<Pelicula> peliculas = new HashSet<>();

    public PersonajeDTO(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public PersonajeDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
