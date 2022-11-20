package com.monolith.example.author.impl.web;

import com.monolith.example.author.impl.config.annotation.CurrentModuleScope;
import com.monolith.example.author.impl.domain.model.Author;
import com.monolith.example.author.impl.domain.service.AuthorService;
import com.monolith.example.integratoin.test.config.annotation.slices.RestControllerTest;
import com.monolith.example.integratoin.test.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerTest(AuthorController.class)
@CurrentModuleScope
class AuthorControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorService authorService;

    @Test
    void registerAuthor() throws Exception {
        //GIVEN
        var author = Author.builder()
                .name("Stephen King")
                .age(74)
                .build();
        var jsonRequest = JsonUtils.convertToJson(author);

        //WHEN
        mockMvc.perform(post("/authors")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        //THEN
    }
}
