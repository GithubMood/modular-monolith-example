package com.monolith.example.iam.impl.domain.service;

import com.monolith.example.iam.api.exception.AuthenticationException;
import com.monolith.example.iam.impl.integration.db.entity.UserEntity;
import com.monolith.example.iam.impl.integration.db.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthenticationProviderImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthenticationProviderImpl authenticationProvider;

    @Test
    void shouldThrowExceptionWhenUsernameIsUnknown() {
        //given
        var username = "unknown";
        var password = "password";

        given(userRepository.findByEmail(username))
                .willReturn(Optional.empty());

        //when
        var exception = assertThrows(AuthenticationException.class,
                () -> authenticationProvider.authenticate(username, password));

        //then
        assertThat(exception.getMessage()).isEqualTo("User not found");
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsIncorrect() {
        //given
        var username = "unknown";
        var password = "password";
        var encodedPassword = "encoded_password";
        var user = UserEntity.builder()
                .id("id")
                .email(username)
                .password(encodedPassword)
                .build();

        given(userRepository.findByEmail(username))
                .willReturn(Optional.of(user));
        given(passwordEncoder.matches(password, encodedPassword))
                .willReturn(false);

        //when
        var exception = assertThrows(Exception.class,
                () -> authenticationProvider.authenticate(username, password));

        //then
        assertThat(exception.getMessage()).isEqualTo("Authentication failed");
    }
}
