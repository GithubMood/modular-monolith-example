package com.monolith.example.iam.impl.domain.service;

import com.monolith.example.common.security.UserDetails;
import com.monolith.example.iam.api.AuthenticationProvider;
import com.monolith.example.iam.api.exception.AuthenticationException;
import com.monolith.example.iam.impl.integration.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationProviderImpl implements AuthenticationProvider {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails authenticate(String username, String password) {
        var user = userRepository.findByEmail(username)
                .orElseThrow(() -> new AuthenticationException("User not found"));

        var isPasswordCorrect = passwordEncoder.matches(password, user.getPassword());
        if (!isPasswordCorrect) {
            throw new AuthenticationException("Authentication failed");
        }

        return UserDetails.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
