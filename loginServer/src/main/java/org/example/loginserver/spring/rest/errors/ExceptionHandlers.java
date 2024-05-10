package org.example.loginserver.spring.rest.errors;

import org.example.loginserver.domain.model.Errors;
import org.example.loginserver.spring.rest.errors.exceptions.CredentialInvalid;
import org.example.loginserver.spring.rest.errors.exceptions.TokenInvalidoException;
import org.example.loginserver.spring.rest.errors.exceptions.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers  {
    @ExceptionHandler(CredentialInvalid.class)
    public ResponseEntity<Errors> handleException(CredentialInvalid e) {
        Errors apiError = new Errors(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(TokenInvalidoException.class)
    public ResponseEntity<Errors> handleException(TokenInvalidoException e) {
        Errors apiError = new Errors(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Errors> handleException(UserExistException e) {
        Errors apiError = new Errors(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
