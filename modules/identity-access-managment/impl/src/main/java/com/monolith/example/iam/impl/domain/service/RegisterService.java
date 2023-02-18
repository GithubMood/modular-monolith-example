package com.monolith.example.iam.impl.domain.service;

import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.iam.impl.integration.db.entity.UserEntity;
import com.monolith.example.iam.impl.integration.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String registerNewUser(NewUserRequest newUserRequest) {
        var newUser = convertToEntity(newUserRequest);
        var savedUser = userRepository.save(newUser);

        return savedUser.getId();
    }

    private UserEntity convertToEntity(NewUserRequest newUserRequest) {
        return UserEntity.builder()
                .email(newUserRequest.getEmail())
                .password(passwordEncoder.encode(newUserRequest.getPassword()))
                .role(newUserRequest.getRole())
                .build();
    }
}
