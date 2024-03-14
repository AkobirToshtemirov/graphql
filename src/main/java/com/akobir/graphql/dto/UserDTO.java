package com.akobir.graphql.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        String fullName,

        @NotBlank
        String email,

        @NotBlank
        String password
) {
}
