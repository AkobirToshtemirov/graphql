package com.akobir.graphql.controller;

import com.akobir.graphql.dto.TodoDTO;
import com.akobir.graphql.entity.Todo;
import com.akobir.graphql.service.TodoService;
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
    public ResponseEntity<Todo> createTodo(@Argument("todo") TodoDTO todoInputDTO) {
        Todo createdTodo = todoService.createTodo(todoInputDTO);
        return ResponseEntity.ok(createdTodo);
    }

    @MutationMapping
    public ResponseEntity<Todo> completeTodo(@Argument("todoId") Long todoId) {
        Todo completedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(completedTodo);
    }

    @MutationMapping
    public ResponseEntity<Void> deleteTodo(@Argument("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok().build();
    }

    @MutationMapping
    public ResponseEntity<Todo> updateTodo(
            @Argument("todoId") Long todoId,
            @Argument("todo") TodoDTO todoInputDTO
    ) {
        Todo updatedTodo = todoService.updateTodo(todoId, todoInputDTO);
        return ResponseEntity.ok(updatedTodo);
    }

    @QueryMapping
    public ResponseEntity<List<Todo>> getTodosByLevel(@Argument("level") String level) {
        List<Todo> todos = todoService.getTodosByLevel(level);
        return ResponseEntity.ok(todos);
    }

    @QueryMapping
    public ResponseEntity<List<Todo>> getTodosByCategory(@Argument("category") String category) {
        List<Todo> todos = todoService.getTodosByCategory(category);
        return ResponseEntity.ok(todos);
    }

    @QueryMapping
    public ResponseEntity<List<Todo>> getTodosByDeadline(@Argument("deadline") LocalDate deadline) {
        List<Todo> todos = todoService.getTodosByDeadline(deadline);
        return ResponseEntity.ok(todos);
    }

    @QueryMapping
    public ResponseEntity<List<Todo>> getTodosByUserId(@Argument("userId") Long userId) {
        List<Todo> todos = todoService.getTodosByUserId(userId);
        return ResponseEntity.ok(todos);
    }
}
