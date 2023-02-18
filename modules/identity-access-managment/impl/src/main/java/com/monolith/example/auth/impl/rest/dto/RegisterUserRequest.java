package com.monolith.example.auth.impl.rest.dto;

import com.monolith.example.common.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    private Role role;
    private String email;
    private String password;
}
