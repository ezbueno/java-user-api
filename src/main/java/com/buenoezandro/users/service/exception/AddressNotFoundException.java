package com.buenoezandro.users.service.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Integer id) {
        super(String.format("Address not found! ID: %s", id));
    }
}
