package com.monolith.example.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monolith.example.integratoin.test.config.annotation.slices.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@ApplicationTest
class RegisterAuthorUseCaseIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void name() {
        //given

        //when

        //then
    }
}
