package com.monolith.example.auth.impl.domain.service;

import com.monolith.example.auth.api.AuthenticationProvider;
import com.monolith.example.auth.api.exception.AuthenticationException;
import com.monolith.example.common.security.Role;
import com.monolith.example.common.security.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class DummyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public UserDetails authenticate(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return UserDetails.builder()
                    .id(1L)
                    .email("admin@email.com")
                    .role(Role.AUTHOR)
                    .build();
        }

        throw new AuthenticationException("Authentication failed");
    }
}
