package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@Configuration
public class SwaggerConfig {

    // Swagger OpenAPI config
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("https://9323.pro604cr.amypo.ai/")
                ));
    }

    // BCrypt encoder bean
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Temporary in-memory login user
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {

        UserDetails user = User.builder()
                .username("root")
                .password(encoder.encode("Amypo"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
