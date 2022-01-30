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
                .age(newAuthor.getAge())
                .name(newAuthor.getName())
                .build();
//        return Mapping.from(Author.class).to(AuthorEntity.class)
//                .omitOtherSourceProperties()
//                .omitInDestination(AuthorEntity::getId)
//                .omitInDestination(AuthorEntity::getCreatedAt)
//                .omitInDestination(AuthorEntity::getLastModifiedAt)
//                .mapper()
//                .map(newAuthor);
    }
}
