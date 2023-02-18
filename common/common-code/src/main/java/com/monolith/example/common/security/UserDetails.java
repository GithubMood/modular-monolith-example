package com.monolith.example.common.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDetails {
    private String id;
    private String email;
    private Role role;
}
