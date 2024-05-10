package org.example.loginserver.spring.rest.errors.exceptions;


import org.example.loginserver.common.Constantes;

public class TokenInvalidoException extends RuntimeException{

    public TokenInvalidoException(String message) {
        super(Constantes.TOKEN_INVALIDO +message);
    }
}
