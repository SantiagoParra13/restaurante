package com.example.backend.models;

public class JwtRequest {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public JwtRequest() {
    }

    public JwtRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}