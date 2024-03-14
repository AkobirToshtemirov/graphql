package com.akobir.graphql.dto;

public record UserDTO(
        String fullName,
        String email,
        String password
) {
}
