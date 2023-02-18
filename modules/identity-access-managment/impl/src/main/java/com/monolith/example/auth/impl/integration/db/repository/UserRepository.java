package com.monolith.example.auth.impl.integration.db.repository;

import com.monolith.example.auth.impl.integration.db.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
