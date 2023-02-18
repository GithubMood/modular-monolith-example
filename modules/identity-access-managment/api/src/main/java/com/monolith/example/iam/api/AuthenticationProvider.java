package com.monolith.example.iam.api;

import com.monolith.example.common.security.UserDetails;
import com.monolith.example.iam.api.exception.AuthenticationException;

public interface AuthenticationProvider {
    UserDetails authenticate(String username, String password) throws AuthenticationException;
}
