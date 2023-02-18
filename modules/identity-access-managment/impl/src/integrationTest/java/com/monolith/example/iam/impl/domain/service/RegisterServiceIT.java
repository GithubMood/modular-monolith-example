package com.monolith.example.iam.impl.domain.service;

import com.monolith.example.common.security.Role;
import com.monolith.example.iam.impl.config.annotation.CurrentModuleScope;
import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.iam.impl.integration.db.repository.UserRepository;
import com.monolith.example.integratoin.test.config.annotation.slices.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
@CurrentModuleScope
class RegisterServiceIT {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldRegisterNewAuthor() {
        //GIVEN
        var newUserRequest = NewUserRequest.builder()
                .email("stephen.king@gmail.com")
                .role(Role.AUTHOR)
                .password("carrie")
                .build();

        //WHEN
        var savedAuthorId = registerService.registerNewUser(newUserRequest);

        //THEN
        var authorEntity = userRepository.findById(savedAuthorId).orElseThrow();
        assertThat(authorEntity.getCreatedAt()).isNotNull();
        assertThat(authorEntity.getLastModifiedAt()).isNotNull();
    }

}
