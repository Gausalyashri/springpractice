/*
Problem: Request Body with a DTO
Accept a JSON request body, automatically deserialized into a
Java DTO (Data Transfer Object), and echo it back.
*/

package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyDto {

    public static class CreateUserRequest {
        private String name;
        private String email;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    // POST /users  with JSON body: {"name": "Ada", "email": "ada@example.com"}
    @PostMapping("/users")
    public String createUser(@RequestBody CreateUserRequest request) {
        return "Created user: " + request.getName() + " (" + request.getEmail() + ")";
    }
}
