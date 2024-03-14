package com.akobir.graphql.controller;

import com.akobir.graphql.dto.UserDTO;
import com.akobir.graphql.entity.User;
import com.akobir.graphql.service.UserService;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
    public User createUser(@Argument("user") @Valid UserDTO user) {
        return userService.createUser(user);
    }

    @QueryMapping
    public User getUser(@Argument("id") Long id) {
        return userService.getUser(id);
    }

    @QueryMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
