package com.monolith.example.writing.impl.integration.db.repository;

import com.monolith.example.writing.impl.integration.db.entity.AuthorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<AuthorEntity, String> {
}
