package com.monolith.example.author.impl.domain.service;

import com.monolith.example.author.impl.config.annotation.CurrentModuleScope;
import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.integration.db.repository.AuthorRepository;
import com.monolith.example.integratoin.test.config.annotation.slices.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
@CurrentModuleScope
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
