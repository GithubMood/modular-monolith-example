package com.monolith.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .httpBasic().disable()
                .authorizeRequests(exchange -> exchange
                                // Unsecured endpoints
                                .antMatchers("/register",
                                        "/login",
                                        "/logout",
                                        "/health/**").permitAll()
                                // Secured endpoints
                                .antMatchers("/test").authenticated()
//                        .anyRequest().authenticated()
                )
                .logout()
                .disable()
//                .invalidateHttpSession(true)
//                .deleteCookies("SESSION")
        ;

        return http.build();
    }
}
