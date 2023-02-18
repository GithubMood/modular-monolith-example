package com.monolith.example.iam.impl.integration.db.repository;

import com.monolith.example.iam.impl.integration.db.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
