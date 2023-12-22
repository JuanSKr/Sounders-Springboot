package com.sk.sounders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "^[^\\s]*$", message = "El nombre de usuario no puede contener espacios.")
    private String username;

    @NotEmpty(message = "Debes escribir una dirección de email.")
    @Email
    private String email;
    @NotEmpty(message = "Debes escribir una contraseña.")
    private String password;
}
