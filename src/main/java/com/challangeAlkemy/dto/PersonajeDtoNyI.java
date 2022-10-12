package com.challangeAlkemy.dto;

import java.io.Serializable;

public class PersonajeDtoNyI implements Serializable {

    private String nombre;
    private String Imagen;

    public PersonajeDtoNyI() {}

    public PersonajeDtoNyI(String nombre, String imagen) {
        this.nombre = nombre;
        Imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    @Override
    public String toString() {
        return "PersonajeDtoNyI{" +
                "nombre='" + nombre + '\'' +
                ", Imagen='" + Imagen + '\'' +
                '}';
    }
}
