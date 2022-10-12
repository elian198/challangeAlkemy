package com.challangeAlkemy.security.payload;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@ApiResponse()
public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
