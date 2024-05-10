package org.example.loginserver.spring.rest.errors.exceptions;

public class CredentialInvalid extends RuntimeException {
    public CredentialInvalid(String message) {
        super(message);
    }
}
