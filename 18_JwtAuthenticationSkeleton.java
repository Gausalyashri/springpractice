/*
Problem: JWT Authentication Skeleton
Show the core pieces of a JWT authentication filter: extracting
the token from the Authorization header, validating it, and
setting the SecurityContext so downstream code sees an
authenticated user.
*/

package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationSkeleton extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (isTokenValid(token)) {
                String username = extractUsername(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    // Placeholder: in real code, verify the JWT signature and expiry
    // (e.g. using the jjwt or nimbus-jose-jwt library).
    private boolean isTokenValid(String token) {
        return token != null && !token.isBlank();
    }

    private String extractUsername(String token) {
        // Placeholder: decode the JWT claims to get the subject.
        return "demo-user";
    }
}
