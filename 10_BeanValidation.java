/*
Problem: Bean Validation
Validate an incoming request body automatically using
Jakarta Bean Validation annotations (@NotNull, @Email, @Size)
together with @Valid on the controller method.
*/

package com.example.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanValidation {

    public static class SignupRequest {
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be 2-50 characters")
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    // If validation fails, Spring automatically returns a 400 Bad Request
    // with a MethodArgumentNotValidException, which can be caught by a
    // @ControllerAdvice for a custom error body.
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest request) {
        return "Signed up: " + request.getName();
    }
}
