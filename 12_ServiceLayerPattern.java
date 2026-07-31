/*
Problem: Layered Architecture (Controller -> Service -> Repository)
Demonstrate the standard three-layer Spring Boot pattern where
the controller delegates business logic to a service, and the
service delegates persistence to a repository.
*/

package com.example.demo.layered;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
class ProductRepository {
    private final Map<Long, String> store = new ConcurrentHashMap<>(Map.of(1L, "Laptop", 2L, "Phone"));

    String findNameById(Long id) {
        return store.get(id);
    }
}

@Service
class ProductService {
    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    String getProductName(Long id) {
        String name = repository.findNameById(id);
        return name != null ? name : "Unknown product";
    }
}

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id) {
        return productService.getProductName(id);
    }
}
