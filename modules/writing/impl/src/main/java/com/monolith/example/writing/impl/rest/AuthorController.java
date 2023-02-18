package com.monolith.example.writing.impl.rest;

import com.monolith.example.writing.impl.domain.model.Author;
import com.monolith.example.writing.impl.domain.service.AuthorService;
import com.monolith.example.writing.impl.rest.dto.AuthorCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorCreatedResponse createAuthor(@RequestBody Author author) {
        var newAuthorId = authorService.registerNewAuthor(author);
        return AuthorCreatedResponse.builder()
                .id(newAuthorId)
                .build();
    }
}
