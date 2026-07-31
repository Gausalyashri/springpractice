/*
Problem: Asynchronous Methods
Run a long-running method on a separate thread using @Async,
returning a CompletableFuture so the caller can wait for or
compose the result without blocking.
*/

package com.example.demo.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Configuration
@EnableAsync
class AsyncConfig {
}

@Service
public class AsyncMethods {

    @Async
    public CompletableFuture<String> processOrder(String orderId) {
        try {
            Thread.sleep(2000); // Simulate slow work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Order " + orderId + " processed");
    }
}
