package com.technical_challenge.Internal.task.management.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super("Email já cadastrado");
    }

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}
