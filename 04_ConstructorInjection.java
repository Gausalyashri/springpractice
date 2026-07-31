/*
Problem: Dependency Injection (Constructor Injection)
Demonstrate the recommended way to inject a Spring bean into
another bean, using constructor injection instead of field
injection (@Autowired on a constructor, or implicit since Spring 4.3
when there is only one constructor).
*/

package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
class GreetingProvider {
    String greet(String name) {
        return "Hello, " + name + "!";
    }
}

@Service
public class GreetingService {

    private final GreetingProvider greetingProvider;

    // Constructor injection: Spring automatically wires GreetingProvider.
    public GreetingService(GreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    public String greetUser(String name) {
        return greetingProvider.greet(name);
    }
}
