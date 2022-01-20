package com.buenoezandro.users.service.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super(String.format("User not found! ID: %s", id));
    }
}
