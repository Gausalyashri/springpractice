/*
Problem: Pagination and Sorting
Return paginated and sorted results from a JPA repository using
Spring Data's Pageable abstraction.
*/

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginationSorting {

    private final UserRepository userRepository;

    public PaginationSorting(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET /api/users/paged?page=0&size=10&sort=name,asc
    @GetMapping("/api/users/paged")
    public Page<User> getUsersPaged(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
