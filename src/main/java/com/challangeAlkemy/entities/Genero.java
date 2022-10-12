package com.challangeAlkemy.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@ApiModel("Entidad Genero")
@Entity
@Table(name = "genero")
public class Genero  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id_genero;

    @Column( name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "GENERO_PELICULAS",
            joinColumns = {
                    @JoinColumn(name = "id_genero")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_pelicula") })
    @ApiModelProperty("Propiedad que tiene una lista set de peliculas asociadas")
    private Set<Pelicula> pelicula;
    public Genero() { }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
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

    public Set<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula(Set<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "GeneroDto{" +
                "id_genero=" + id_genero +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", pelicula=" + pelicula +
                '}';
    }
}


