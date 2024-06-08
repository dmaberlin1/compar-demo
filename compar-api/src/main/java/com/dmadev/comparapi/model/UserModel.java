package com.dmadev.comparapi.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserModel {
    private Long id;
    private String username;
    private String name;
    private String surname;
}
