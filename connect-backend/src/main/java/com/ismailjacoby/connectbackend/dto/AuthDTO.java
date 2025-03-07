package com.ismailjacoby.connectbackend.dto;

import com.ismailjacoby.connectbackend.model.enums.UserRole;

public record AuthDTO(
        String username,
        String token,
        UserRole role
) {
}
