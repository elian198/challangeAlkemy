package com.challangeAlkemy.dto;

import com.challangeAlkemy.entities.Personaje;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PeliculasDTO implements Serializable {

    private Long id;
    private String imagen;
    private String tiutlo;
    private Date fecha;
    private Integer Calificacion;
    private Set<Personaje> personaje = new HashSet<>();
    public PeliculasDTO() {}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTiutlo() {
        return tiutlo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTiutlo(String tiutlo) {
        this.tiutlo = tiutlo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        Calificacion = calificacion;
    }

    public Set<Personaje> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Set<Personaje> personaje) {
        this.personaje = personaje;
    }
}
