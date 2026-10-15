package com.org.movie.moviemanagementsystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Movie Management System",
         description = "Movie Management System API",
        version = "1.0.0",
        contact = @Contact(name = "Arjun patel",
                email = "arjun@gmail.com")))
public class OpenApiConfig {

}
