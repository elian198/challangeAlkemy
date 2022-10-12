package com.challangeAlkemy.dto;

import java.io.Serializable;
import java.util.Date;

public class PeliculaDtoITF implements Serializable {

    private String imagen;
    private String titulo;
    private Date fecha;

    public PeliculaDtoITF() {}

    public PeliculaDtoITF(String imagen, String titulo, Date fecha) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "PeliculaDtoITF{" +
                "imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
