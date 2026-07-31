/*
Problem: OpenAPI / Swagger Documentation
Configure springdoc-openapi to generate interactive API
documentation (served at /swagger-ui.html) with basic metadata
about the API.
*/

package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Demo API")
                        .version("1.0")
                        .description("REST API documentation for the Demo application"));
    }
}

// pom.xml dependency needed:
// <dependency>
//     <groupId>org.springdoc</groupId>
//     <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
//     <version>2.5.0</version>
// </dependency>
