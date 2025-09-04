package com.technical_challenge.Internal.task.management.infra;

import com.technical_challenge.Internal.task.management.exceptions.EmailAlreadyRegisteredException;
import com.technical_challenge.Internal.task.management.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    private ResponseEntity<String> emailAlreadyRegisteredHandler(EmailAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email já cadastrado");
    }

    @ExceptionHandler(IdNotFoundException.class)
    private ResponseEntity<String> idNotFoundHandler(IdNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
    }

}
