package com.challangeAlkemy.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@ApiModel("Entidad Personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")

    private Long id;

    @Column( name = "imagen")
    private String imagen;
    @Column( name = "nombre")
    private String nombre;
    @Column( name = "edad" )
    private Integer edad;
    @Column( name = "peso")
    private Double peso;
    @Column( name = "historia")
    private String historia;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSONAJE_PELICULAS",
            joinColumns = {
                    @JoinColumn(name = "id_personaje")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_pelicula") })
    @ApiModelProperty("propiedad que tiene una set de pelicula(puede tener varias peliculas)")
    private Set<Pelicula> pelicula;
    public Personaje() { }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
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

    public Set<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula(Set<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", pelicula=" + pelicula +
                '}';
    }
}

