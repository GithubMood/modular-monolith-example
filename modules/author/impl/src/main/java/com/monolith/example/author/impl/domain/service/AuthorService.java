package com.monolith.example.author.impl.domain.service;

import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.integration.db.entity.AuthorEntity;
import com.monolith.example.author.impl.integration.db.repository.AuthorRepository;
import com.remondis.remap.Mapping;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorService {
    AuthorRepository authorRepository;

    public String registerNewAuthor(Author newAuthor) {
        var newAuthorEntity = convertToEntity(newAuthor);
        var savedAuthor = authorRepository.save(newAuthorEntity);

        return savedAuthor.getId();
    }

    private AuthorEntity convertToEntity(Author newAuthor) {
        return Mapping.from(Author.class).to(AuthorEntity.class)
                .omitOtherSourceProperties()
                .omitInDestination(AuthorEntity::getId)
                .omitInDestination(AuthorEntity::getCreatedAt)
                .omitInDestination(AuthorEntity::getLastModifiedAt)
                .mapper()
                .map(newAuthor);
    }
}
