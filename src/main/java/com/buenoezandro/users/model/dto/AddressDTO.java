package com.buenoezandro.users.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AddressDTO implements Serializable {
    private Integer id;
    private String street;
    private String city;
}
