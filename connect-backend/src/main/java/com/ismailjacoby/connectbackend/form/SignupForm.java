package com.ismailjacoby.connectbackend.form;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SignupForm (
        @NotBlank(message = "Username is required.")
        @Size(min = 4, message = "Username must be at least 4 characters long.")
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores.")
        String username,

        @NotBlank(message = "Password is required.")
        @Size(min = 8, message = "Password must be at least 8 characters long.")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>\\-=])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>\\-=]{8,}$",
                message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
        String password,

        @NotBlank(message = "First name is required.")
        @Size(min = 2, message = "First name must be at least 2 characters long.")
        String firstName,

        @NotBlank(message = "Lastname is required.")
        @Size(min = 2, message = "Last name must be at least 2 characters long.")
        String lastName,

        @NotBlank(message = "Email is required.")
        @Email(message = "Invalid email address format.")
        String email,

        @PastOrPresent(message = "Birthdate cannot be in the future.")
        LocalDate birthDate
){
}
