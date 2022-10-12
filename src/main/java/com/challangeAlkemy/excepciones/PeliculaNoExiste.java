package com.challangeAlkemy.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PeliculaNoExiste extends ResponseStatusException {
    public PeliculaNoExiste(HttpStatus badRequest, String mensaje) {
        super(HttpStatus.NOT_FOUND, mensaje);
    }
}
