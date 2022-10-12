package com.challangeAlkemy.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSeEncontroPelicula extends ResponseStatusException {
    public NoSeEncontroPelicula(HttpStatus status, String mensaje) {
        super(status, mensaje);
    }
}
