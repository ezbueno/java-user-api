package com.buenoezandro.users.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class UserModelDTO implements Serializable {
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String occupation;

    @NotNull
    private Integer age;
}
