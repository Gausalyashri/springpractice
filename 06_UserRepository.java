/*
Problem: Spring Data JPA Repository
Create a repository interface for the User entity. Extending
JpaRepository gives CRUD methods for free (save, findById,
findAll, deleteById, etc.) with no implementation required.
*/

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Derived query method: Spring generates the SQL from the method name.
    Optional<User> findByEmail(String email);
}
