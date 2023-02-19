package com.monolith.example.gateway.web;

import com.monolith.example.gateway.web.dto.LoginRequest;
import com.monolith.example.iam.api.AuthenticationProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request) {
        var email = request.getEmail();
        var password = request.getPassword();
        var user = authenticationProvider.authenticate(email, password);

        var roleAuthority = new SimpleGrantedAuthority(user.getRole().name());
        Collection<? extends GrantedAuthority> authorities = List.of(roleAuthority);

        var authentication = new UsernamePasswordAuthenticationToken(user, "", List.of(roleAuthority));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
