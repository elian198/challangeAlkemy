package com.challangeAlkemy.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioNoExiste extends ResponseStatusException {
    public UsuarioNoExiste(HttpStatus status, String mensaje) {
        super(status, mensaje);
    }
}
