package org.example.loginserver.spring.rest.errors.exceptions;


import org.example.loginserver.common.Constantes;

public class UserExistException extends RuntimeException{

    public UserExistException() {
        super(Constantes.ESE_USER_YA_EXISTE);
    }
}
