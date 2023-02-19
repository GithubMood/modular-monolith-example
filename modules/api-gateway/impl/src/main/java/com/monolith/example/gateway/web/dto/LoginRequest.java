package com.monolith.example.gateway.web.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String email;
    @ToString.Exclude
    private String password;
}
