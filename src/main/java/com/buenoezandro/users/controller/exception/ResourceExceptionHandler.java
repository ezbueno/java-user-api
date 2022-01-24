package com.buenoezandro.users.controller.exception;

import com.buenoezandro.users.service.exception.AddressNotFoundException;
import com.buenoezandro.users.service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ResourceExceptionHandler {
    private static final String MESSAGE = "Erro na validação dos campos!";

    @ExceptionHandler(value = UserNotFoundException.class)
    private ResponseEntity<StandardError> userNotFoundException(UserNotFoundException e) {
        var error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = AddressNotFoundException.class)
    private ResponseEntity<StandardError> addressNotFoundException(AddressNotFoundException e) {
        var error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    private ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException e) {
        var error = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e) {
        var error = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), MESSAGE);

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            error.addErrors(fieldName, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
