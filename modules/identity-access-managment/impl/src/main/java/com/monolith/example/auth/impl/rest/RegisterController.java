package com.monolith.example.auth.impl.rest;

import com.monolith.example.auth.impl.domain.dto.NewUserRequest;
import com.monolith.example.auth.impl.domain.service.RegisterService;
import com.monolith.example.auth.impl.rest.dto.UserRegisteredResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisteredResponse registerNewUser(NewUserRequest newUserRequest) {
        var userId = registerService.registerNewUser(newUserRequest);

        return UserRegisteredResponse.builder()
                .id(userId)
                .build();
    }
}
