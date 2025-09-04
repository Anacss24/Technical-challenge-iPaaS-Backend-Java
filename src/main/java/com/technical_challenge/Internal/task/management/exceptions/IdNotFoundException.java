package com.technical_challenge.Internal.task.management.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException() {
        super("ID não encontrado");
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
