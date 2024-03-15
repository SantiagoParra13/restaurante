package com.example.backend.models;

public class JwtResponse {
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public JwtResponse(final String token) {
        this.token = token;
    }

    public JwtResponse() {
    }
}
