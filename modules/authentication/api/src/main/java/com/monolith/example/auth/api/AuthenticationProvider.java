package com.monolith.example.auth.api;

import com.monolith.example.auth.api.exception.AuthenticationException;
import com.monolith.example.common.security.UserDetails;

public interface AuthenticationProvider {
    UserDetails authenticate(String username, String password) throws AuthenticationException;
}
