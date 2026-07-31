/*
Problem: Custom Query Methods (Derived Queries and @Query)
Demonstrate Spring Data JPA derived query methods (generated
from the method name) and a custom JPQL query using @Query.
*/

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserQueryRepository extends JpaRepository<User, Long> {

    // Derived query: SELECT * FROM users WHERE name LIKE %:name%
    List<User> findByNameContainingIgnoreCase(String name);

    // Derived query: SELECT * FROM users WHERE email = ?
    List<User> findByEmailEndingWith(String domainSuffix);

    // Custom JPQL query
    @Query("SELECT u FROM User u WHERE u.name = :name AND u.email LIKE %:domain%")
    List<User> searchByNameAndDomain(@Param("name") String name, @Param("domain") String domain);
}
