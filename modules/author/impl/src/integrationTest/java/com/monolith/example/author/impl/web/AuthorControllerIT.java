package com.monolith.example.author.impl.web;

import com.monolith.example.author.impl.config.annotation.slices.RestControllerTest;
import com.monolith.example.author.impl.domain.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerTest(AuthorController.class)
class AuthorControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorService authorService;

    @Test
    void registerAuthor() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(post("/authors")
                        .content("""
                                {"name" : "dima",
                                 "age" : 10
                                }
                                """)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


        //THEN
    }
}
