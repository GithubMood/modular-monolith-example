package com.monolith.example.author.impl.domain.service;

import com.monolith.example.author.impl.config.annotation.slices.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@ApplicationTest
class AuthorServiceIT {
    @Autowired
    private AuthorService authorService;

    @Test
    void justTest(){
        var value = authorService.getValue();
    }
}
