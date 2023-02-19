package com.monolith.example.common.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserDetails implements Serializable {
    private String id;
    private String email;
    private Role role;
}
