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
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "El nombre de usuario solo puede contener letras, números y '_'.")
    private String username;

    @NotEmpty(message = "Debes escribir una dirección de email.")
    @Email(message = "Por favor, introduce un formato de correo electrónico válido", regexp="^.+@.+\\.com$")
    private String email;

    @NotEmpty(message = "Debes escribir una contraseña.")
    private String password;

    @NotEmpty(message = "Debes confirmar tu contraseña.")
    private String confirmPassword;
}
