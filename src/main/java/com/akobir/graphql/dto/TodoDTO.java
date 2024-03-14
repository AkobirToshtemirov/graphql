package com.akobir.graphql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TodoDTO(
        Long userId,

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        String category,

        @NotBlank
        String level,

        @NotBlank
        LocalDate deadline,

        @NotNull
        boolean completed
) {
}
