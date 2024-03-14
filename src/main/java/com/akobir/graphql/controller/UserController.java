package com.akobir.graphql.controller;

import com.akobir.graphql.dto.UserDTO;
import com.akobir.graphql.entity.User;
import com.akobir.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public ResponseEntity<User> createUser(@Argument("user") UserDTO userInputDTO) {
        User createdUser = userService.createUser(userInputDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @QueryMapping
    public ResponseEntity<User> getUser(@Argument("id") Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @QueryMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
