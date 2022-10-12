package com.challangeAlkemy.dto;

import com.challangeAlkemy.entities.Pelicula;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GeneroDTO implements Serializable {

  private   String nombre;
  private   String imagen;
  private Set<Pelicula> peliculasDTO = new HashSet<>();
    public GeneroDTO() {}

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

    public Set<Pelicula> getPeliculasDTO() {
        return peliculasDTO;
    }

    public void setPeliculasDTO(Set<Pelicula> peliculasDTO) {
        this.peliculasDTO = peliculasDTO;
    }
}
