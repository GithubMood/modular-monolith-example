package com.monolith.example.gateway.web;

import com.monolith.example.iam.api.AuthenticationProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SecuredController {
    private final AuthenticationProvider authenticationProvider;

    @GetMapping("/test")
    public void login() {
        log.info("I am inside secured method");
    }
}
