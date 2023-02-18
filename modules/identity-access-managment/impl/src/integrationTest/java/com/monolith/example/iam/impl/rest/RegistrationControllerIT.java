package com.monolith.example.iam.impl.rest;

import com.monolith.example.common.security.Role;
import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.iam.impl.domain.service.RegisterService;
import com.monolith.example.integratoin.test.config.annotation.InjectJsonUtils;
import com.monolith.example.integratoin.test.config.annotation.slices.RestControllerTest;
import com.monolith.example.integratoin.test.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerTest(RegistrationController.class)
class RegistrationControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @InjectJsonUtils
    private JsonUtils jsonUtils;

    @MockBean
    private RegisterService registerService;

    @Test
    void shouldRegisterNewUser() throws Exception {
        //given
        var author = NewUserRequest.builder()
                .email("stephen.king@gmail.com")
                .password("carrie")
                .role(Role.AUTHOR)
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
