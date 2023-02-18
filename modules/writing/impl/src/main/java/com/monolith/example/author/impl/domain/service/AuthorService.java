package com.monolith.example.author.impl.domain.service;

import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.integration.db.entity.AuthorEntity;
import com.monolith.example.author.impl.integration.db.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public String registerNewAuthor(Author newAuthor) {
        var newAuthorEntity = convertToEntity(newAuthor);
        var savedAuthor = authorRepository.save(newAuthorEntity);

        return savedAuthor.getId();
    }

    private AuthorEntity convertToEntity(Author newAuthor) {
        return AuthorEntity.builder()
                .name(newAuthor.getName())
                .age(newAuthor.getAge())
                .build();
    }
}
