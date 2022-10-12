package com.challangeAlkemy.security.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiResponse;

import java.io.PrintStream;
import java.security.PrivateKey;

@ApiModel("Clase para enviar datos al crear usuario")
public class RegisterRequest {
    private String nombre;

    private  String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
