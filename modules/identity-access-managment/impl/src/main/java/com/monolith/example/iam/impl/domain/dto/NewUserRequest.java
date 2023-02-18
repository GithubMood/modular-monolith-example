package com.monolith.example.iam.impl.domain.dto;

import com.monolith.example.common.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest {
    private Role role;
    private String email;
    private String password;
}
