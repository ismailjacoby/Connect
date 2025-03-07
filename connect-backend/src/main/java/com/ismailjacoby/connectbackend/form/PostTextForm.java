package com.ismailjacoby.connectbackend.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostTextForm (
        @NotBlank(message = "Text message is required.")
        @Size(max = 255, message = "Text cannot exceed 255")
        String text){
}
