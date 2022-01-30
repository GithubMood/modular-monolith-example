package com.monolith.example.author.impl.domain.service;

import com.monolith.example.author.impl.config.annotation.slices.ApplicationTest;
import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.integration.db.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class AuthorServiceIT {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void shouldRegisterNewAuthor() {
        //GIVEN
        var newAuthor = Author.builder()
                .name("Stephen King")
                .age(74)
                .build();

        //WHEN
        var savedAuthorId = authorService.registerNewAuthor(newAuthor);

        //THEN
        var authorEntity = authorRepository.findById(savedAuthorId).orElseThrow();
        assertThat(authorEntity.getCreatedAt()).isNotNull();
        assertThat(authorEntity.getLastModifiedAt()).isNotNull();
    }
}
