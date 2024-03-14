package com.akobir.graphql.service.impl;

import com.akobir.graphql.dto.UserDTO;
import com.akobir.graphql.entity.User;
import com.akobir.graphql.exception.NotFoundException;
import com.akobir.graphql.repository.UserRepository;
import com.akobir.graphql.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User createUser(UserDTO userDTO) {
        User user = new User();

        user.setFullName(userDTO.fullName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());

        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
