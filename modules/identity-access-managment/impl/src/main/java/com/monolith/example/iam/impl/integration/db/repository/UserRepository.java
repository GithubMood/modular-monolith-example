package com.monolith.example.iam.impl.integration.db.repository;

import com.monolith.example.iam.impl.integration.db.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
