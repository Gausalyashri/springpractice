/*
Problem: Caching with @Cacheable
Cache the result of an expensive method call so repeated calls
with the same argument skip the underlying computation, using
Spring's caching abstraction.
*/

package com.example.demo.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@EnableCaching
class CachingConfig {
}

@Service
public class CachingWithCacheable {

    @Cacheable("products")
    public String getProductDetails(String productId) {
        simulateSlowLookup();
        return "Details for product " + productId;
    }

    @CacheEvict(value = "products", key = "#productId")
    public void invalidateProduct(String productId) {
        // Removes the cached entry so the next call recomputes it.
    }

    private void simulateSlowLookup() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
