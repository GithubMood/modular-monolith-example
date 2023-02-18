package com.monolith.example.writing.impl.integration.db.repository;

import com.monolith.example.integratoin.test.config.annotation.slices.MongoTest;
import com.monolith.example.writing.impl.config.annotation.CurrentModuleScope;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@MongoTest
@CurrentModuleScope
class AuthorRepositoryIT {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findById() {
        //GIVEN
        var id = "1";

        //WHEN
        var result = authorRepository.findById(id);

        //THEN
        assertThat(result).isEmpty();
    }
}
