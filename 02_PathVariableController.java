/*
Problem: Path Variables and Request Parameters
Demonstrate reading a value from the URL path (@PathVariable) and
an optional query parameter (@RequestParam).
*/

package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    // GET /users/42
    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id) {
        return "User with id: " + id;
    }

    // GET /search?query=spring&page=1  (page defaults to 0 if absent)
    @GetMapping("/search")
    public String search(@RequestParam String query,
                          @RequestParam(defaultValue = "0") int page) {
        return "Searching for '" + query + "' on page " + page;
    }
}
