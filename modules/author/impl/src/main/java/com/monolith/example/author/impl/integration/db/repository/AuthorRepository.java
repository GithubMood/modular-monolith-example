package com.monolith.example.author.impl.integration.db.repository;

import com.monolith.example.author.impl.integration.db.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
