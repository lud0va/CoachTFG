package org.example.restserver.domain.errors;

public class DiaRepetidoException extends  RuntimeException{
    public DiaRepetidoException() {
        super("El dia introducido esta repetido");
    }
}
