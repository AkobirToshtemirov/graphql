package com.akobir.graphql.repository;

import com.akobir.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
