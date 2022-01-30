package com.monolith.example.author.impl.integration.db.repository;

import com.monolith.example.author.impl.config.annotation.slices.PersistenceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@PersistenceTest
public class AuthorRepositoryIT {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findById(){
        //GIVEN
        var id = "1";

        //WHEN
        var result = authorRepository.findById(id);

        //THEN
        assertThat(result).isEmpty();
    }
}
