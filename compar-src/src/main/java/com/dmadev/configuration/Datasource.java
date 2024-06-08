package com.dmadev.configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datasource {

    @NotBlank(message = "URL must not be blank")
    @Pattern(regexp = "^jdbc:.*", message = "URL must start with 'jdbc:'")
    private String url;

    @NotBlank(message = "Username must not be blank")
    @Pattern(regexp = "\\S+", message = "Username must not contain spaces")
    private String username;
    @NotBlank(message = "Password must not be blank")
    @Pattern(regexp = "\\S+", message = "Password must not contain spaces")
    private String password;
    @NotBlank(message = "Migration must not be blank")
    private String migration;
}
