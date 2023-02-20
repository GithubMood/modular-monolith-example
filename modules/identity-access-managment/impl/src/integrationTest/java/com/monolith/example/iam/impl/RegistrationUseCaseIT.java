package com.monolith.example.iam.impl;

import com.monolith.example.common.security.Role;
import com.monolith.example.iam.api.AuthenticationProvider;
import com.monolith.example.iam.impl.config.annotation.CurrentModuleTest;
import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.iam.impl.domain.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@CurrentModuleTest
class RegistrationUseCaseIT {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private RegisterService registerService;

    @Test
    void shouldSuccessfullyRegister() {
        //given
        var email = "new_user@email.com";
        var password = "random_password";
        var newUserRequest = NewUserRequest.builder()
                .email(email)
                .password(password)
                .role(Role.AUTHOR)
                .build();

        //when register
        var userId = registerService.registerNewUser(newUserRequest);

        //and authenticate
        var userDetails = authenticationProvider.authenticate(email, password);

        //then
        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getId()).isEqualTo(userId);
        assertThat(userDetails.getEmail()).isEqualTo(email);
        assertThat(userDetails.getRole()).isEqualTo(Role.AUTHOR);
    }
}
