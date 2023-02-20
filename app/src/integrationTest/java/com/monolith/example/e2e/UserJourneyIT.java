package com.monolith.example.e2e;

import com.monolith.example.common.security.Role;
import com.monolith.example.config.annotation.ApplicationTest;
import com.monolith.example.gateway.web.dto.LoginRequest;
import com.monolith.example.iam.impl.domain.dto.NewUserRequest;
import com.monolith.example.integratoin.test.config.annotation.InjectJsonUtils;
import com.monolith.example.integratoin.test.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ApplicationTest
class UserJourneyIT {
    private static final String X_AUTH_TOKEN = "X-Auth-Token";
    @Autowired
    private MockMvc mockMvc;
    @InjectJsonUtils
    private JsonUtils jsonUtils;

    @Test
    void shouldPerformEndToEndUserJourneySuccessfully() throws Exception {
        var authorEmail = "stephen.king@gmail.com";
        var authorPassword = "carrie";

        registerAuthor(authorEmail, authorPassword);
        var authToken = login(authorEmail, authorPassword);

        assertTestCallSecured();
        makeTestCall(authToken);

        logout(authToken);
    }

    private void registerAuthor(String email, String password) throws Exception {
        var author = NewUserRequest.builder()
                .email(email)
                .password(password)
                .role(Role.AUTHOR)
                .build();
        var jsonRequest = jsonUtils.convertToJson(author);

        mockMvc.perform(post("/register")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private String login(String email, String password) throws Exception {
        var loginRequest = LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
        var jsonRequest = jsonUtils.convertToJson(loginRequest);

        var response = mockMvc.perform(post("/login")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        return response.getResponse().getHeader(X_AUTH_TOKEN);
    }

    private void makeTestCall(String authToken) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                        .header(X_AUTH_TOKEN, authToken))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

    private void assertTestCallSecured() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden())
                .andReturn();
    }

    private void logout(String authToken) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/logout")
                        .header(X_AUTH_TOKEN, authToken))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
