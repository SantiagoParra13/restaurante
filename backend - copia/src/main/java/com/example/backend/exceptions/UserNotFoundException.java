package com.example.backend.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("El Usuario con ese username ya se encuentra registrado, vuelva a intentar");
    }

    public UserNotFoundException(String mensage) {
        super(mensage);
    }
}
