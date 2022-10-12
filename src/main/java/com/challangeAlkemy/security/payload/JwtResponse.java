package com.challangeAlkemy.security.payload;

import io.swagger.annotations.ApiModel;

@ApiModel("Clase para enviar el token en formato String")
public class JwtResponse {

    private String token;

    public JwtResponse() {
    }
    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

