package com.ismailjacoby.connectbackend.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginForm (
        @NotBlank(message = "Username is required.")
        @Size(min = 4, message = "Username must be at least 4 characters long.")
        String usernameOrEmail,

        @NotBlank(message = "Password is required.")
        @Size(min = 8, message = "Password must be at least 8 characters long.")
        String password
) {
}
