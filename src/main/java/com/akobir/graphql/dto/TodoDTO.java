package com.akobir.graphql.dto;

import com.akobir.graphql.entity.enums.Category;
import com.akobir.graphql.entity.enums.Level;

import java.time.LocalDate;

public record TodoDTO(
        Long userId,
        String title,
        String description,
        Category category,
        Level level,
        LocalDate deadline,
        boolean completed
) {
}
