package com.akobir.graphql.repository;

import com.akobir.graphql.entity.Todo;
import com.akobir.graphql.entity.enums.Category;
import com.akobir.graphql.entity.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByLevel(Level level);

    List<Todo> findByCategory(Category category);

    List<Todo> findByDeadline(LocalDate date);

    List<Todo> findByUserId(Long userId);
}
