package com.monolith.example.author.impl.web;

import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.domain.service.AuthorService;
import com.monolith.example.author.impl.web.dto.AuthorCreatedResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {
    AuthorService authorService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorCreatedResponse createReport(@RequestBody Author author) {
        if (true) {
            throw new IllegalArgumentException("baaad");
        }
        var newAuthorId = authorService.registerNewAuthor(author);
        return AuthorCreatedResponse.builder()
                .id(newAuthorId)
                .build();
    }
}
