package com.monolith.example.iam.impl.rest;

import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.iam.impl.domain.service.RegisterService;
import com.monolith.example.iam.impl.rest.dto.UserRegisteredResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private final RegisterService registerService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisteredResponse registerNewUser(@RequestBody NewUserRequest newUserRequest) {
        var userId = registerService.registerNewUser(newUserRequest);

        return UserRegisteredResponse.builder()
                .id(userId)
                .build();
    }
}
