package com.akobir.graphql.service;

import com.akobir.graphql.dto.UserDTO;
import com.akobir.graphql.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);

    User getUser(Long id);

    List<User> getAllUsers();
}
