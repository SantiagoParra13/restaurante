package com.example.backend.exceptions;


public class UserFoundException extends Exception {
    public UserFoundException() {
        super("El Usuario con ese username ya se encuentra registrado, vuelva a intentar");
    }

    public UserFoundException(String mensage) {
        super(mensage);
    }
}
