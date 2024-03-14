package com.akobir.graphql.service.impl;

import com.akobir.graphql.dto.TodoDTO;
import com.akobir.graphql.entity.Todo;
import com.akobir.graphql.entity.User;
import com.akobir.graphql.entity.enums.Category;
import com.akobir.graphql.entity.enums.Level;
import com.akobir.graphql.exception.NotFoundException;
import com.akobir.graphql.repository.TodoRepository;
import com.akobir.graphql.repository.UserRepository;
import com.akobir.graphql.service.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;


    public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Todo createTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();

        todo.setTitle(todoDTO.title());
        todo.setDescription(todoDTO.description());
        todo.setCategory(Enum.valueOf(Category.class, todoDTO.category()));
        todo.setLevel(Enum.valueOf(Level.class, todoDTO.level()));
        todo.setDeadline(todoDTO.deadline());

        User user = userRepository.findById(todoDTO.userId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + todoDTO.userId()));

        todo.setUser(user);
        todo.setCompleted(todoDTO.completed());

        return todoRepository.save(todo);
    }

    @Override
    @Transactional
    public Todo completeTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NotFoundException("Todo not found with id: " + todoId));

        todo.setCompleted(true);

        return todoRepository.save(todo);
    }

    @Override
    @Transactional
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    @Transactional
    public Todo updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Todo not found with id: " + id));

        todo.setTitle(todoDTO.title());
        todo.setDescription(todoDTO.description());
        todo.setCategory(Enum.valueOf(Category.class, todoDTO.category()));
        todo.setLevel(Enum.valueOf(Level.class, todoDTO.level()));
        todo.setDeadline(todoDTO.deadline());
        todo.setCompleted(todoDTO.completed());

        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodosByLevel(String level) {
        return todoRepository.findByLevel(Enum.valueOf(Level.class, level));
    }

    @Override
    public List<Todo> getTodosByCategory(String category) {
        return todoRepository.findByCategory(Enum.valueOf(Category.class, category));
    }

    @Override
    public List<Todo> getTodosByDeadline(LocalDate deadline) {
        return todoRepository.findByDeadline(deadline);
    }

    @Override
    public List<Todo> getTodosByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }

}
