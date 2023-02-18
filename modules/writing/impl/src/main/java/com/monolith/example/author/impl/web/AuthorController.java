package com.monolith.example.author.impl.web;

import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.domain.service.AuthorService;
import com.monolith.example.author.impl.web.dto.AuthorCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
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
