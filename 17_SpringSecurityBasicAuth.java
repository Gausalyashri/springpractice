/*
Problem: Spring Security - Basic HTTP Authentication
Configure Spring Security to require HTTP Basic authentication
for all endpoints except a public health-check endpoint, using
the modern SecurityFilterChain bean style (Spring Security 6+).
*/

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityBasicAuth {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/health", "/actuator/health").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(basic -> {}); // Enable HTTP Basic auth

        return http.build();
    }
}
