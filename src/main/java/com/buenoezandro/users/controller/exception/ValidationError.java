package com.buenoezandro.users.controller.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ValidationError extends StandardError {
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String message) {
        super(timestamp, status, message);
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
