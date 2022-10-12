package com.challangeAlkemy.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.Optional;
import java.util.Set;
@ApiModel("Entidad Pelicula")
@Entity
public class Pelicula{
        @ApiModelProperty("Clave ficticia autoincremental tipo Long")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column( name = "imagen")
        private String imagen;
        @Column(  name = "titulo")
        private String titulo;
        @Column( name = "fecha")
        private Date fecha;
        @Column(name = "calificacion")
        private Integer calificacion;


        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "PELICULA_PERSONAJES",
            joinColumns = {
                    @JoinColumn(name = "id_pelicula")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_personaje") })
        @ApiModelProperty("Propiedad que tiene una lista tipo set de personajes(puede tener varios personajes")
        private Set<Personaje> personaje;
        public Pelicula() {
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Set<Personaje> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Pelicula personaje) {
        this.personaje = (Set<Personaje>) personaje;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", calificacion=" + calificacion +
                ", personaje=" + personaje +
                '}';
    }
}


