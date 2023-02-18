package com.monolith.example.auth.impl.rest;

import com.monolith.example.auth.impl.rest.dto.RegisterUserRequest;
import com.monolith.example.common.security.Role;
import com.monolith.example.integratoin.test.config.annotation.InjectJsonUtils;
import com.monolith.example.integratoin.test.config.annotation.slices.RestControllerTest;
import com.monolith.example.integratoin.test.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerTest(RegisterController.class)
class RegisterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @InjectJsonUtils
    private JsonUtils jsonUtils;

    @Test
    void shouldRegisterNewUser() throws Exception {
        //given
        var author = RegisterUserRequest.builder()
                .email("stephen.king@gmail.com")
                .role(Role.AUTHOR)
                .password("Carrie")
                .build();
        var jsonRequest = jsonUtils.convertToJson(author);

        //when
        mockMvc.perform(post("/register")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isCreated());

    }
}
