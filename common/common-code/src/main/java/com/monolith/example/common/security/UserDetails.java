package com.monolith.example.common.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDetails {
    private Long id;
    private String email;
    private Role role;
}
