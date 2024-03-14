package com.akobir.graphql.service;

import com.akobir.graphql.dto.TodoDTO;
import com.akobir.graphql.entity.Todo;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {
    Todo createTodo(TodoDTO todoDTO);

    Todo completeTodo(Long todoId);

    void deleteTodo(Long todoId);

    Todo updateTodo(Long id, TodoDTO todoDTO);

    List<Todo> getTodosByLevel(String level);

    List<Todo> getTodosByCategory(String category);

    List<Todo> getTodosByDeadline(LocalDate deadline);

    List<Todo> getTodosByUserId(Long userId);

}
