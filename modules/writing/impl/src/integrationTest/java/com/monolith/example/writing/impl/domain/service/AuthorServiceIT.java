package com.monolith.example.writing.impl.domain.service;

import com.monolith.example.integratoin.test.config.annotation.slices.ApplicationTest;
import com.monolith.example.writing.impl.config.annotation.CurrentModuleScope;
import com.monolith.example.writing.impl.domain.model.Author;
import com.monolith.example.writing.impl.integration.db.repository.AuthorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        Assertions.assertThat(authorEntity.getCreatedAt()).isNotNull();
        Assertions.assertThat(authorEntity.getLastModifiedAt()).isNotNull();
    }
}
