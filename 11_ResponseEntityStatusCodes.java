/*
Problem: ResponseEntity and HTTP Status Codes
Demonstrate returning different HTTP status codes explicitly
(200, 201, 204, 404) using ResponseEntity.
*/

package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ResponseEntityStatusCodes {

    @GetMapping("/{id}")
    public ResponseEntity<String> getItem(@PathVariable int id) {
        if (id == 1) {
            return ResponseEntity.ok("Item #1"); // 200 OK
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found"); // 404
    }

    @PostMapping
    public ResponseEntity<String> createItem() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created"); // 201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        return ResponseEntity.noContent().build(); // 204
    }
}
