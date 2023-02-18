package com.monolith.example.iam.impl.domain.service;

import com.monolith.example.common.security.Role;
import com.monolith.example.common.security.UserDetails;
import com.monolith.example.iam.api.AuthenticationProvider;
import com.monolith.example.iam.api.exception.AuthenticationException;
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
