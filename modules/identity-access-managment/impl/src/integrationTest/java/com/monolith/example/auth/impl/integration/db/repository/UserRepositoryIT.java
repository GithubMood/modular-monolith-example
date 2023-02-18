package com.monolith.example.auth.impl.integration.db.repository;

import com.monolith.example.auth.impl.config.annotation.CurrentModuleScope;
import com.monolith.example.auth.impl.integration.db.entity.UserEntity;
import com.monolith.example.common.security.Role;
import com.monolith.example.integratoin.test.config.annotation.slices.MongoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@MongoTest
@CurrentModuleScope
class UserRepositoryIT {
    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldNotInsertUserDuplicates() {
        //given
        var email = "email@gmail.com";
        var newUser = user(email);
        var duplicateUser = user(email);

        //when
        userRepository.save(newUser);

        //then
        assertThrows(DuplicateKeyException.class,
                () -> userRepository.save(duplicateUser));
    }

    private static UserEntity user(String email) {
        return UserEntity.builder()
                .email(email)
                .password("password")
                .role(Role.AUTHOR)
                .build();
    }
}
