package com.akobir.graphql.controller;

import com.akobir.graphql.dto.TodoDTO;
import com.akobir.graphql.entity.Todo;
import com.akobir.graphql.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @MutationMapping
    public Todo createTodo(@Argument("todo") @Valid TodoDTO todoInputDTO) {
        return todoService.createTodo(todoInputDTO);
    }

    @MutationMapping
    public Todo completeTodo(@Argument("todoId") Long todoId) {
        return todoService.completeTodo(todoId);
    }

    @MutationMapping
    public ResponseEntity<Void> deleteTodo(@Argument("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok().build();
    }

    @MutationMapping
    public Todo updateTodo(
            @Argument("todoId") Long todoId,
            @Argument("todo") @Valid TodoDTO todoInputDTO
    ) {
        return todoService.updateTodo(todoId, todoInputDTO);
    }

    @QueryMapping
    public List<Todo> getTodosByLevel(@Argument("level") String level) {
        return todoService.getTodosByLevel(level);
    }

    @QueryMapping
    public List<Todo> getTodosByCategory(@Argument("category") String category) {
        return todoService.getTodosByCategory(category);
    }

    @QueryMapping
    public List<Todo> getTodosByDeadline(@Argument("deadline") LocalDate deadline) {
        return todoService.getTodosByDeadline(deadline);
    }

    @QueryMapping
    public List<Todo> getTodosByUserId(@Argument("userId") Long userId) {
        return todoService.getTodosByUserId(userId);
    }
}
