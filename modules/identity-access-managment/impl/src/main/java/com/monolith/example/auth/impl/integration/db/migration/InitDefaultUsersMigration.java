package com.monolith.example.auth.impl.integration.db.migration;

import com.monolith.example.auth.impl.domain.dto.NewUserRequest;
import com.monolith.example.auth.impl.domain.service.RegisterService;
import com.monolith.example.auth.impl.integration.db.entity.UserEntity;
import com.monolith.example.common.security.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDefaultUsersMigration {
    private final MongoTemplate mongoTemplate;
    private final RegisterService registerService;

    @Value("${database.init.admin.email}")
    private final String adminEmail;
    @Value("${database.init.admin.email}")
    private final String adminPassword;

    @PostConstruct
    public void initUsers() {
        var isUserCollectionExist = mongoTemplate.collectionExists(UserEntity.class);
        if (!isUserCollectionExist) {
            log.info("There are no users in the system. Registering default admin user with email [{}]", adminEmail);
            var admin = NewUserRequest.builder()
                    .email(adminEmail)
                    .password(adminPassword)
                    .role(Role.ADMIN)
                    .build();
            registerService.registerNewUser(admin);
        }
    }
}
